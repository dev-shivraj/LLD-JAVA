# Java `synchronized` Methods

## <span style="color:#1E88E5;">🔵 Key Idea</span>

## <span style="color:#D32F2F;">When you use a `synchronized` instance method, Java locks the object on which the method is called.</span>

In this example, if you call:

```text
value.increment();
```

then the object being locked is:

```text
value
```

<span style="color:#2E7D32;">✅ Not the thread</span>  
<span style="color:#2E7D32;">✅ Not the `Adder` object</span>  
<span style="color:#2E7D32;">✅ Not the `Subtractor` object</span>

---

## <span style="color:#1E88E5;">Overview</span>

A `synchronized` method is one of the easiest ways to make code thread-safe.

When an instance method is marked with `synchronized`, only one thread at a time can execute any synchronized method of that same object.

Java does this by using the object's internal monitor, also called the intrinsic lock.

---

## <span style="color:#1E88E5;">Example</span>

```java
public class Value {
    private int x;

    public synchronized void increment() {
        this.x++;
    }

    public synchronized void decrement() {
        this.x--;
    }
}
```

Both methods are synchronized, so a thread must first acquire the monitor of the `Value` object before entering either method.

---

## <span style="color:#1E88E5;">How It Applies to Your Program</span>

Both `Adder` and `Subtractor` share the same `Value` object:

```java
Value value = new Value(0);
Adder adder = new Adder(value);
Subtractor subtractor = new Subtractor(value);
```

That means both threads compete for the same monitor.

```text
                Value object
                   x = 0
             [ hidden monitor ]
                ▲           ▲
                │           │
         Adder Thread   Subtractor Thread
```

<span style="color:#FB8C00;">Because the shared object is the same, only one thread can enter its synchronized methods at a time.</span>

---

## <span style="color:#1E88E5;">What Actually Happens?</span>

Assume both threads start at the same time.

### <span style="color:#6A1B9A;">Step 1: Thread A calls `value.increment()`</span>

```text
value.increment();
```

Internally, the JVM does this:

```text
Acquire monitor of value
        ↓
Execute increment()
        ↓
Release monitor
```

At this moment, Thread A owns the monitor of `value`.

---

### <span style="color:#6A1B9A;">Step 2: Thread B calls `value.decrement()`</span>

```text
value.decrement();
```

The JVM checks the monitor and sees:

```text
Monitor owner = Thread A
```

Since the monitor is already taken, Thread B cannot enter the method. It becomes blocked and waits.

---

### <span style="color:#6A1B9A;">Step 3: Thread A finishes</span>

```java
public synchronized void increment() {
    this.x++;
}
```

As soon as the method ends, the JVM automatically releases the monitor.

<span style="color:#2E7D32;">✅ No manual unlock is needed.</span>

---

### <span style="color:#6A1B9A;">Step 4: Thread B gets the monitor</span>

Once Thread A leaves the method, one waiting thread is allowed to continue.

Now:

```text
Monitor owner = Thread B
```

Thread B can finally execute:

```text
value.decrement();
```

---

## <span style="color:#1E88E5;">Internal Meaning of a Synchronized Method</span>

This method:

```java
public synchronized void increment() {
    this.x++;
}
```

is conceptually similar to:

```java
public void increment() {
    synchronized (this) {
        this.x++;
    }
}
```

So a synchronized instance method is basically shorthand for synchronizing on `this`.

---

## <span style="color:#1E88E5;">Which Object Gets Locked?</span>

This is the most important part.

If you write:

```text
value.increment();
```

then the lock is taken on:

```text
value
```

<span style="color:#D32F2F;">❌ Not `Adder`</span>  
<span style="color:#D32F2F;">❌ Not `Subtractor`</span>  
<span style="color:#D32F2F;">❌ Not the thread itself</span>

### <span style="color:#2E7D32;">✅ The object used to call the method is what gets locked.</span>

---

## <span style="color:#1E88E5;">Why This Works</span>

Both threads call synchronized methods on the same object:

```text
Thread A ──► value.increment()
Thread B ──► value.decrement()
```

Inside those methods, synchronization happens on:

```text
this
```

And in this case:

```text
this == value
```

So both threads compete for the same monitor, and only one of them can enter at a time.

---

## <span style="color:#1E88E5;">What If We Use Two Different `Value` Objects?</span>

```java
Value value1 = new Value(0);
Value value2 = new Value(0);

Adder adder = new Adder(value1);
Subtractor subtractor = new Subtractor(value2);
```

Now the threads are using different objects, so they are using different monitors.

```text
Thread A ──► monitor of value1
Thread B ──► monitor of value2
```

Since the locks are different, both methods can run at the same time.

<span style="color:#FB8C00;">No synchronization happens between different objects.</span>

---

## <span style="color:#1E88E5;">What About Context Switching?</span>

Suppose Thread A enters:

```text
value.increment();
```

and the scheduler pauses Thread A before the method finishes.

Does Java release the lock?

<span style="color:#D32F2F;">No.</span>

The monitor still belongs to Thread A, so Thread B must continue waiting.

The monitor is released only when Thread A exits the synchronized method.

---

## <span style="color:#1E88E5;">What If the Thread Sleeps?</span>

```java
public synchronized void increment() throws Exception {
    Thread.sleep(5000);
    x++;
}
```

Even while sleeping, the thread still owns the monitor.

<span style="color:#D32F2F;">Sleeping does not release the lock.</span>

All other threads trying to enter synchronized code on the same object must wait.

---

## <span style="color:#1E88E5;">What If an Exception Happens?</span>

```java
public synchronized void increment() {
    throw new RuntimeException();
}
```

If the method exits because of an exception, the JVM still releases the monitor automatically.

This is one reason `synchronized` is safer than manual locking, where forgetting to unlock can cause problems.

---

## <span style="color:#1E88E5;">Are Synchronized Methods Reentrant?</span>

Yes.

```java
public synchronized void methodA() {
    methodB();
}

public synchronized void methodB() {
}
```

If the same thread already owns the monitor in `methodA()`, it is allowed to enter `methodB()` too.

```text
Thread A
  ↓
methodA()
  ↓
owns monitor
  ↓
calls methodB()
  ↓
already owns monitor
  ↓
allowed to enter
```

Java keeps an internal count for how many times the same thread has re-entered the same monitor.

---

## <span style="color:#1E88E5;">Multiple Threads Calling the Same Object</span>

```java
Value value = new Value(0);
```

If many threads do this:

```text
value.increment();
```

then all of them compete for the same monitor.

```text
               Value monitor
                    │
      ┌─────────────┼─────────────┐
      │             │             │
   Thread 1      Thread 2      Thread 3
      │             │             │
      └─────────────┼─────────────┘
                    │
              Only one enters
```

Only one thread can execute the synchronized method at a time. The others wait.

---

## <span style="color:#1E88E5;">Multiple Threads Calling Different Objects</span>

```java
Value value1 = new Value(0);
Value value2 = new Value(0);
```

```text
Thread A ──► monitor of value1
Thread B ──► monitor of value2
```

These are different monitors, so both threads can run concurrently.

---

## <span style="color:#1E88E5;">Is the Entire Object Locked?</span>

Not exactly.

The monitor belongs to the object, but only code that tries to enter synchronized sections guarded by that monitor is blocked.

Non-synchronized methods can still run.

Example:

```java
public void print() {
    System.out.println(x);
}
```

This method can run even while another thread is executing:

```java
public synchronized void increment() {
    x++;
}
```

because `print()` does not acquire the object's monitor.

---

## <span style="color:#1E88E5;">Synchronized Method vs Synchronized Block</span>

### Method form

```java
public synchronized void increment() {
    x++;
}
```

### Equivalent block form

```java
public void increment() {
    synchronized (this) {
        x++;
    }
}
```

The method form is simply a shorter way to synchronize on `this` for the entire method body.

---

## <span style="color:#1E88E5;">Advantages</span>

- Simple syntax
- Automatic lock acquisition and release
- Exception-safe lock release
- Helps prevent race conditions
- Reentrant
- No risk of forgetting `unlock()`

---

## <span style="color:#1E88E5;">Limitations</span>

- No `tryLock()`
- No timeout support
- No fairness policy
- Locks the whole method, even if only a small section needs protection
- Less flexible than `ReentrantLock`

---

## <span style="color:#1E88E5;">`synchronized` Method vs `synchronized` Block</span>

| `synchronized` Method | `synchronized` Block |
|---|---|
| Locks `this` automatically | You choose which object to lock |
| Entire method is synchronized | Only the chosen section is synchronized |
| Very simple syntax | More flexible |
| Cannot lock only part of a method | Can protect only the critical section |

---

## <span style="color:#1E88E5;">`synchronized` vs `ReentrantLock`</span>

| `synchronized` | `ReentrantLock` |
|---|---|
| Built into Java | Uses a separate lock object |
| Automatic lock release | Manual `unlock()` required |
| Uses the object's monitor | Uses an explicit `Lock` implementation |
| Simpler | More flexible |
| Exception-safe by default | Usually needs `try-finally` |
| No `tryLock()` | Supports `tryLock()` |
| No fairness configuration | Optional fair locking |
| Reentrant | Reentrant |

---

## <span style="color:#1E88E5;">Interview Takeaways</span>

- Every Java object has its own hidden monitor.
- A synchronized instance method locks the current object, that is, `this`.
- Only one thread can execute synchronized code guarded by the same monitor at a time.
- Different objects have different monitors.
- `Thread.sleep()` does not release the monitor.
- Context switching does not release the monitor.
- The JVM automatically releases the monitor when the synchronized method exits, even if it exits because of an exception.
- `synchronized` is reentrant, so the same thread can acquire the same monitor multiple times.
- A synchronized instance method is conceptually equivalent to wrapping the full method body inside `synchronized(this)`.
