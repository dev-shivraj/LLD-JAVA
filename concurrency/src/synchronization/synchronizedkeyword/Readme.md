# Java `synchronized` Keyword

## What is `synchronized`?

`synchronized` is Java's built-in synchronization mechanism.

Its purpose is to ensure that **only one thread can execute a critical section at a time**, preventing race conditions and ensuring data consistency.

Unlike `ReentrantLock`, you do **not** manually acquire or release the lock.

The JVM automatically:

1. Acquires the lock before entering the synchronized block.
2. Executes the critical section.
3. Releases the lock when leaving the block (even if an exception occurs).

---

# Basic Syntax

## Synchronized Block

```java
synchronized (lockObject) {
    // Critical Section
}
```

## Synchronized Method

```java
public synchronized void increment() {
    count++;
}
```

Both achieve the same goal.

---

# What Gets Locked?

This is the **most important concept**.

The object inside the parentheses is what gets locked.

```java
synchronized (someObject) {
    // Critical Section
}
```

The lock belongs to **someObject**, not the code.

Always ask yourself:

> **Which object is inside `synchronized(...)`?**

That object is the monitor (lock).

---

# Example 1 - Synchronizing on a Shared Object

```java
Value value = new Value(0);

Adder adder = new Adder(value);
Subtractor subtractor = new Subtractor(value);
```

Inside both classes:

```java
synchronized (this.value) {
    value.setX(value.getX() + 1);
}
```

Both threads synchronize on the **same Value object**.

```
            Value Object
           (Monitor Lock)
                 ▲
         ┌───────┴────────┐
         │                │
     Adder Thread    Subtractor Thread
```

Only one thread can execute the synchronized block at a time.

---

# Execution

Suppose:

```
Thread A -> Adder

Thread B -> Subtractor
```

Thread A enters first.

```
Thread A

↓

Gets Value's Monitor

↓

Executes Critical Section
```

Thread B reaches

```java
synchronized(value)
```

Java checks:

```
Is Value's monitor already owned?
```

Answer:

```
Yes
```

Thread B waits.

When Thread A exits the synchronized block:

```
Monitor Released

↓

Thread B acquires the monitor

↓

Thread B executes
```

---

# Which Object is Locked?

Suppose you have

```java
Value value = new Value(0);
```

and

```java
Adder adder = new Adder(value);
Subtractor subtractor = new Subtractor(value);
```

The following statement

```java
synchronized(this.value)
```

locks

```
The Value Object
```

It **does NOT lock**

- Adder
- Subtractor
- The code itself

It locks only the **Value instance**.

---

# Multiple Threads of the Same Adder Object

Suppose

```java
Adder adder = new Adder(value);
```

Two threads execute

```java
Thread A -> adder.call();

Thread B -> adder.call();
```

Both execute

```java
synchronized(this.value)
```

Both are trying to acquire the monitor of the same Value object.

```
          Value
            ▲
     ┌──────┴──────┐
     │             │
 Thread A      Thread B
```

Only one enters.

The other waits.

---

# Two Different Adder Objects

Suppose

```java
Adder adder1 = new Adder(value);
Adder adder2 = new Adder(value);
```

Even though there are two different Adder objects,

both synchronize on

```java
synchronized(value)
```

Diagram:

```
adder1
     \
      \
      Value
      /
     /
adder2
```

Still,

only one thread executes at a time.

Reason:

Both are locking the **same Value object**.

---

# Different Value Objects

Suppose

```java
Adder adder1 = new Adder(new Value(0));

Adder adder2 = new Adder(new Value(0));
```

Now

```
adder1 ------ Value1

adder2 ------ Value2
```

These are two completely different monitor locks.

Therefore,

both threads execute simultaneously.

---

# What if We Synchronize on `this`?

Example

```java
public void add() {

    synchronized(this) {

        value.setX(value.getX() + 1);

    }

}
```

Now the lock belongs to

```
The Adder Object
```

instead of the Value object.

---

## Same Adder Object

```
Adder
   ▲
   │
Thread A
Thread B
```

Only one thread enters.

---

## Different Adder Objects

```
Adder1

↓

Thread A
```

```
Adder2

↓

Thread B
```

Different monitor locks.

Both execute simultaneously.

---

# Instance Synchronized Method

```java
public synchronized void increment() {

}
```

is exactly equivalent to

```java
public void increment() {

    synchronized(this) {

    }

}
```

The current object (`this`) is used as the monitor lock.

---

# Static Synchronized Method

```java
public static synchronized void print() {

}
```

This is equivalent to

```java
synchronized(MyClass.class) {

}
```

It locks the **Class object**, not an instance.

Example:

```java
Counter c1 = new Counter();

Counter c2 = new Counter();
```

Even though there are two objects,

calling a static synchronized method uses

```
Counter.class
```

as the monitor.

Only one thread can execute it.

---

# Is `synchronized` Reentrant?

**Yes.**

The monitor used by `synchronized` is reentrant.

That means

> The thread already owning the monitor can acquire it again.

Example

```java
public synchronized void methodA() {

    methodB();

}

public synchronized void methodB() {

}
```

Execution

```
Thread A

↓

methodA()

↓

Gets Monitor

↓

Calls methodB()

↓

Already owns Monitor

↓

Allowed to Enter
```

No deadlock occurs.

---

# What if `synchronized` Was Not Reentrant?

```
Thread A

↓

methodA()

↓

Gets Lock

↓

Calls methodB()

↓

Needs Same Lock Again

↓

Wait Forever
```

The thread would block itself.

This is called **Self Deadlock**.

Java prevents this because monitors are reentrant.

---

# `synchronized` vs `ReentrantLock`

| Feature | synchronized | ReentrantLock |
|----------|-------------|---------------|
| Built into Java | ✅ | ❌ |
| Automatic lock release | ✅ | ❌ |
| Manual unlock required | ❌ | ✅ |
| Reentrant | ✅ | ✅ |
| tryLock() | ❌ | ✅ |
| Fair Lock | ❌ | ✅ |
| Interruptible Lock | ❌ | ✅ |
| Multiple Conditions | ❌ | ✅ |
| Simpler | ✅ | ❌ |
| More Powerful | ❌ | ✅ |

---

# Golden Rule

Whenever you see

```java
synchronized(someObject)
```

Always ask:

> **Which object is `someObject`?**

That object is the monitor lock.

Threads synchronize **only if they use the same monitor object**.

Different monitor objects mean different locks.

---

# Interview Questions

### Q1. What object gets locked in `synchronized(this)`?

**Answer:**

The current object (`this`) is locked.

---

### Q2. What object gets locked in `synchronized(value)`?

**Answer:**

The `value` object is locked.

---

### Q3. Can two different Adder objects block each other?

**Answer:**

- **Yes**, if they synchronize on the same `Value` object.
- **No**, if they synchronize on different `Value` objects.

---

### Q4. Can Adder and Subtractor block each other?

**Answer:**

Yes.

If both synchronize on the same `Value` object, only one thread can execute the critical section at a time.

---

### Q5. Is `synchronized` reentrant?

**Answer:**

Yes.

The same thread can acquire the same monitor multiple times without blocking itself.

---

# Interview Definition

> **The `synchronized` keyword is Java's built-in synchronization mechanism that uses an object's intrinsic monitor lock to ensure that only one thread at a time can execute a synchronized block or method for that monitor. The JVM automatically acquires the monitor before entering the critical section and releases it upon exit, even if an exception occurs. Java monitors are reentrant, allowing the same thread to acquire the same monitor multiple times without causing a self-deadlock.**