# Java `ReentrantLock` Explained

## What is a Lock?

A `Lock` is a synchronization mechanism that ensures **only one thread can execute a critical section at a time**.

It prevents **race conditions** when multiple threads access the same shared resource.

```java
Lock lock = new ReentrantLock();
```

The above statement creates a single `Lock` object that can be shared among multiple threads.

---

# Is the Lock on the Variable or the Code?

**Neither.**

A `Lock` is attached to the **Lock object**, **not** to a variable or a block of code.

```java
Lock lock = new ReentrantLock();
```

This object internally keeps track of:

- Which thread currently owns the lock
- Which threads are waiting
- How many times the owner has acquired the lock (Hold Count)

The code between

```java
lock.lock();

// Critical Section

lock.unlock();
```

is protected **only because every thread agrees to acquire the same lock before executing it.**

---

# What is a Critical Section?

A **critical section** is the part of the code that accesses shared data.

Example:

```java
value.setX(value.getX() + 1);
```

This statement is **not atomic**.

Internally it performs three operations:

```
Read x
↓

Add 1
↓

Write x
```

If another thread modifies `x` between these steps, a race condition occurs.

---

# Why Do We Need a Lock?

Without synchronization:

```
Initial value = 0

Adder:
Read 0

                Subtractor:
                Read 0

Adder:
Write 1

                Subtractor:
                Write -1
```

Final value becomes **-1** instead of **0**.

With a lock:

```
Adder
lock()

Read 0

Write 1

unlock()

                Subtractor
                lock()

                Read 1

                Write 0

                unlock()
```

Only one thread enters the critical section at a time.

---

# How Does `lock.lock()` Work?

When a thread executes:

```java
lock.lock();
```

Java checks:

```
Is the lock free?
```

### If YES

The thread becomes the owner.

```
Owner = Thread A
```

### If NO

The thread waits.

```
Owner = Thread A

Waiting Queue

Thread B
Thread C
```

Once the owner calls:

```java
lock.unlock();
```

Java wakes one waiting thread.

---

# What Does `unlock()` Do?

`unlock()` releases the lock.

```java
lock.unlock();
```

After unlocking:

```
Owner = none
```

Now another waiting thread can acquire the lock.

---

# What Happens If We Forget `unlock()`?

Example:

```java
lock.lock();

value.setX(value.getX() + 1);

// unlock forgotten
```

The lock remains owned forever.

```
Owner = Thread A
```

When another thread executes

```java
lock.lock();
```

it waits forever.

```
Thread A
Owns Lock

↓

Thread B
Waiting Forever
```

Your program appears to hang.

---

# Always Use `try-finally`

Correct approach:

```java
lock.lock();

try {
    value.setX(value.getX() + 1);
} finally {
    lock.unlock();
}
```

Even if an exception occurs, the lock is always released.

---

# What if Only One Thread Uses the Lock?

Suppose:

### Adder

```java
lock.lock();

try {
    value.setX(value.getX() + 1);
} finally {
    lock.unlock();
}
```

### Subtractor

```java
value.setX(value.getX() - 1);
```

Here, `Subtractor` completely ignores the lock.

It can modify the shared variable at any time.

The lock **cannot stop a thread that doesn't use it.**

Therefore,

> **Every thread accessing the shared resource must use the same lock.**

---

# One Lock Shared by All Threads

Correct:

```
             Shared Value
                 ▲
                 │
      ┌──────────┴──────────┐
      │                     │
   Adder               Subtractor
      │                     │
      └──── Same Lock ──────┘
```

Incorrect:

```
Adder ---------- Lock A

Subtractor ----- Lock B
```

Different locks do **not** synchronize with each other.

---

# What is a Reentrant Lock?

A **Reentrant Lock** allows **the same thread** to acquire the lock multiple times.

It does **not** block itself.

---

## Example

```java
lock.lock();   // Hold Count = 1

lock.lock();   // Hold Count = 2

lock.lock();   // Hold Count = 3

lock.unlock(); // Hold Count = 2

lock.unlock(); // Hold Count = 1

lock.unlock(); // Hold Count = 0
```

The lock is actually released **only when the Hold Count becomes 0.**

---

# Why is it Called "Reentrant"?

"Reentrant" means

> A thread can **re-enter** code protected by the same lock without blocking itself.

Example:

```java
Lock lock = new ReentrantLock();

public void methodA() {
    lock.lock();

    try {
        methodB();
    } finally {
        lock.unlock();
    }
}

public void methodB() {
    lock.lock();

    try {
        System.out.println("Inside methodB");
    } finally {
        lock.unlock();
    }
}
```

Execution:

```
Thread A

↓

methodA()

↓

lock()   Hold Count = 1

↓

methodB()

↓

lock()   Hold Count = 2

↓

unlock() Hold Count = 1

↓

unlock() Hold Count = 0
```

The same thread successfully acquires the lock twice.

---

# What Would Happen Without Reentrancy?

Imagine a non-reentrant lock.

```
Thread A

↓

lock()

↓

methodB()

↓

lock()

↓

Wait Forever
```

The thread would wait for itself.

This is called a **Self Deadlock**.

`ReentrantLock` prevents this problem.

---

# Internal State of a `ReentrantLock`

Conceptually, it stores:

```
Owner Thread

Hold Count

Waiting Queue
```

Example:

```
Owner = Thread A

Hold Count = 2

Waiting Queue

Thread B
Thread C
```

When Thread A performs two `unlock()` calls:

```
Owner = Thread B

Hold Count = 1
```

Thread B becomes the new owner.

---

# Difference Between Lock and Variable

The lock is **not attached to the variable**.

It is simply an object that threads agree to use.

Example:

```java
Lock lock = new ReentrantLock();
```

Nothing prevents another thread from modifying the variable like this:

```java
value.setX(100);
```

unless it also follows the same locking protocol.

Locks work through **cooperation**, not enforcement.

---

# Interview Definition

> A `ReentrantLock` is a synchronization mechanism that allows only one thread at a time to execute a critical section. Unlike a normal lock, the thread that currently owns the lock can acquire it multiple times without blocking itself. Each successful `lock()` call increases an internal **Hold Count**, and the lock is fully released only after the same number of `unlock()` calls.