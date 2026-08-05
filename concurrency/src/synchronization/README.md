# Java `synchronized` Keyword - Complete Guide

## Table of Contents

1. What is `synchronized`?
2. How `synchronized` Works
3. What Gets Locked?
4. Monitor Lock (Intrinsic Lock)
5. Critical Section
6. Same Object vs Different Objects
7. `synchronized(this)` vs `synchronized(value)`
8. Same Thread vs Different Thread
9. Is `synchronized` Reentrant?
10. Thread Scheduling & Synchronization
11. `Thread.sleep()` with `synchronized`
12. `synchronized` vs `ReentrantLock`
13. Interview Questions
14. Interview Definition

---

# 1. What is `synchronized`?

`synchronized` is Java's built-in synchronization mechanism.

It ensures that:

- Only one thread can execute a critical section at a time.
- Shared data remains consistent.
- Race conditions are prevented.

Unlike `ReentrantLock`, you never manually acquire or release the lock.

The JVM does it automatically.

---

# 2. How `synchronized` Works

Example

```java
synchronized(value) {

    value.setX(value.getX() + 1);

}
```

Internally the JVM performs:

```
Acquire value's Monitor

↓

Execute Critical Section

↓

Release value's Monitor
```

Unlike `ReentrantLock`, there is no explicit

```java
lock.lock();

lock.unlock();
```

The JVM manages everything.

---

# 3. What Gets Locked?

This is the most important concept.

Whenever you write

```java
synchronized(someObject)
```

Always ask

> **Which object is `someObject`?**

That object gets locked.

Not

- the variable
- the method
- the code

Only the object inside `synchronized(...)`.

---

Example

```java
Value value = new Value(0);

synchronized(value) {

}
```

The monitor belongs to

```
Value Object
```

---

# 4. Every Java Object Has a Hidden Monitor

Every Java object secretly contains an intrinsic lock called a **Monitor**.

Conceptually

```
+---------------------------+
| Value Object              |
|                           |
| int x                     |
|                           |
| Hidden Monitor Lock       |
+---------------------------+
```

When you write

```java
synchronized(value)
```

the JVM acquires

```
Value's Hidden Monitor
```

---

# 5. What is a Critical Section?

A critical section is code accessing shared data.

Example

```java
value++;
```

Internally

```
Read

↓

Modify

↓

Write
```

Without synchronization another thread may modify the value in between.

---

# 6. Example with Shared Value

Suppose

```java
Value value = new Value(0);

Adder adder = new Adder(value);

Subtractor subtractor = new Subtractor(value);
```

Both execute

```java
synchronized(value)
```

Diagram

```
            Value
      (Monitor Lock)

        ▲         ▲

     Adder    Subtractor
```

Only one thread enters.

---

# Execution

Thread A

```
Gets Monitor

↓

Updates Value
```

Thread B

```
Reaches synchronized(value)

↓

Monitor already owned

↓

Waits
```

After Thread A exits

```
Monitor Released

↓

Thread B Gets Monitor
```

---

# 7. Same Object vs Different Objects

## Case 1

Same Value object

```java
Adder(new Value(0));
Subtractor(same Value);
```

```
            Value
             ▲
      ┌──────┴──────┐
      │             │
 Thread A      Thread B
```

Only one executes.

---

## Case 2

Different Value objects

```java
Adder(new Value(0));

Subtractor(new Value(0));
```

Diagram

```
Value1 Monitor

↓

Thread A
```

```
Value2 Monitor

↓

Thread B
```

Different monitors.

Both threads execute simultaneously.

---

# 8. `synchronized(this)`

Example

```java
synchronized(this) {

}
```

The monitor belongs to

```
Current Object
```

---

## Same Adder Object

```java
Adder adder = new Adder(value);
```

Threads

```
Thread A

↓

adder.call()
```

```
Thread B

↓

adder.call()
```

Diagram

```
      Adder Object
      (Monitor)

       ▲       ▲

   ThreadA ThreadB
```

Only one thread enters.

---

## Different Adder Objects

```java
Adder adder1 = new Adder(value);

Adder adder2 = new Adder(value);
```

Diagram

```
Adder1 Monitor

↓

Thread A
```

```
Adder2 Monitor

↓

Thread B
```

Both execute simultaneously.

---

# 9. Same Thread vs Different Thread

This is where many beginners get confused.

Synchronization cares about

```
Thread Identity
```

Not

- Adder
- Subtractor
- Class
- Method

---

## Same Thread

Suppose

```
Thread A
```

already owns

```
Value Monitor
```

Thread A again executes

```java
synchronized(value)
```

Java checks

```
Current Thread == Owner Thread ?
```

Answer

```
YES
```

Allowed.

---

## Different Thread

Suppose

Thread B executes

```java
synchronized(value)
```

Java checks

```
Current Thread == Owner Thread ?
```

Answer

```
NO
```

Thread B waits.

---

# 10. Is `synchronized` Reentrant?

**YES**

Java monitors are reentrant.

That means

> The thread already owning the monitor can acquire it again.

---

Example

```java
public void methodA() {

    synchronized(value) {

        methodB();

    }

}

public void methodB() {

    synchronized(value) {

        System.out.println("Inside");

    }

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

Needs Same Monitor

↓

Already Owner

↓

Allowed
```

No deadlock.

---

# What if Java Was Not Reentrant?

```
Thread A

↓

Gets Monitor

↓

Calls methodB()

↓

Needs Monitor Again

↓

Wait Forever
```

Thread A would wait for itself.

This is called

```
Self Deadlock
```

Java avoids this.

---

# 11. Thread Scheduling

Suppose

```
Thread A
```

owns the monitor.

The scheduler pauses Thread A.

```
CPU

↓

Thread B
```

Does Thread A lose the monitor?

**NO**

Ownership does not change.

```
Monitor Owner = Thread A
```

Thread B reaches

```java
synchronized(value)
```

Thread B waits.

Only when Thread A exits the synchronized block does the JVM release the monitor.

---

# 12. Thread.sleep()

Example

```java
synchronized(value) {

    Thread.sleep(5000);

}
```

Question

Does sleeping release the monitor?

**NO**

For 5 seconds

```
Thread A

↓

Sleeping

↓

Still Owns Monitor
```

Every other thread waits.

---

# 13. Two Threads of Same Adder Object

Suppose

```java
Adder adder = new Adder(value);
```

Thread A

```
adder.call()
```

Thread B

```
adder.call()
```

Both synchronize on

```java
synchronized(value)
```

Thread A enters.

Thread B waits.

Reason

Both need

```
Value's Monitor
```

---

# 14. Why Reentrant?

Imagine

```java
methodA()

↓

methodB()
```

Both synchronized on the same object.

Without reentrancy

```
Thread waits for itself

↓

Deadlock
```

With reentrancy

```
Same Thread

↓

Already Owns Monitor

↓

Allowed
```

---

# 15. `synchronized` vs `ReentrantLock`

| synchronized | ReentrantLock |
|--------------|---------------|
| Built into JVM | Java Class |
| Hidden Monitor | Lock Object |
| Automatic acquire | `lock()` |
| Automatic release | `unlock()` |
| Cannot forget release | Must use `finally` |
| Reentrant | Reentrant |
| Easier | More Powerful |
| No `tryLock()` | Supports `tryLock()` |
| No Fair Lock | Supports Fair Lock |

---

# Easy Memory Trick

Every Java object has a hidden lock.

```
Object

+----------------------+

Data

Hidden Monitor

+----------------------+
```

Whenever you write

```java
synchronized(object)
```

You are saying

> Acquire this object's hidden monitor before executing the critical section.

---

# Golden Rule

Whenever you see

```java
synchronized(someObject)
```

Ask yourself

> Which object is `someObject`?

That object is the lock.

Threads synchronize only if they use the same monitor.

Different monitor objects mean no synchronization.

---

# Common Interview Questions

### Q1. What gets locked?

The object inside `synchronized(...)`.

---

### Q2. Is `synchronized` reentrant?

Yes.

The same thread can acquire the same monitor multiple times.

---

### Q3. Does `Thread.sleep()` release the monitor?

No.

---

### Q4. Does scheduler preemption release the monitor?

No.

---

### Q5. Can another thread of the same object enter?

No.

If another thread tries to acquire the same monitor, it waits.

---

### Q6. Does synchronization depend on the object or the thread?

Ownership depends on the **thread**.

The monitor belongs to an **object**.

The JVM internally checks:

```
Who owns this object's monitor?
```

If the requesting thread is the owner,

it can enter again.

Otherwise,

it waits.

---

# Interview Definition

> **The `synchronized` keyword is Java's built-in synchronization mechanism that uses an object's intrinsic monitor lock to protect critical sections. Only one thread can own a monitor at a time. The monitor is automatically acquired when entering the synchronized block or method and automatically released when exiting it. Java monitors are reentrant, allowing the same thread to acquire the same monitor multiple times without blocking itself, while other threads must wait until the monitor is released.**