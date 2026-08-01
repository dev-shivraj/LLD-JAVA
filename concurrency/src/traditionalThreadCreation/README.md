# Traditional Thread Creation in Java

# Table of Contents

1. Overview
2. Fundamental Concepts
    - Program
    - Process
    - Thread
    - CPU
    - Core
    - Physical Core
    - Logical (Virtual) Core
    - Hyper-Threading
3. Who Runs Processes and Threads?
4. Concurrency vs Parallelism
5. Context Switching
6. Thread Count and the Sweet Spot
7. Checking CPU Cores
    - Java Code
    - Activity Monitor (macOS)
    - Task Manager (Windows)
8. Key Concept: Threads Only Understand Tasks
9. The 4-Step Thread Creation Process
10. Files in This Package
11. Running the Code
12. Output Examples
13. Important Concepts
14. Common Pitfalls
15. Thread Lifecycle
16. Further Reading

---

# Overview

This package demonstrates the fundamental concepts of creating and managing threads in Java using the traditional `Runnable` interface approach.

Along with thread creation, this documentation also explains the complete foundation of multithreading including:

- Program
- Process
- Thread
- CPU
- Core
- Physical vs Logical (Virtual) Cores
- Hyper-Threading
- Process Scheduler
- Thread Scheduler
- Context Switching
- Concurrency
- Parallelism
- Choosing the correct number of threads
- Checking CPU cores on your machine

This documentation is intended for beginners who want to understand **how Java threads actually execute on hardware** before learning advanced topics like Thread Pools and ExecutorService.

---

# Fundamental Concepts

## 1. Program

A **Program** is simply a collection of instructions stored on disk.

Examples:

- Chrome.exe
- IntelliJ IDEA
- Spotify
- Java application (.jar)

A program is **passive**.

It is **not running**.

It occupies only storage.

Example:

```
Calculator.exe
```

Until you open it, it is only a program.

---

## 2. Process

A **Process** is a running instance of a program.

When you double-click Chrome,

```
Chrome.exe
```

becomes

```
Chrome Process
```

A process has its own:

- Memory
- Heap
- Stack
- Open files
- Resources

Each process is isolated from other processes.

Example:

```
Chrome
Spotify
VS Code
IntelliJ

Each is a separate process.
```

---

## 3. Thread

A Thread is the **smallest unit of execution** inside a process.

A process always contains at least **one thread**.

This first thread is called the **Main Thread**.

Example:

```
Chrome Process

    Main Thread
    Render Thread
    Network Thread
    GPU Thread
    Audio Thread
```

All these threads share

- Heap
- Variables
- Files
- Objects

but each thread has its own

- Program Counter
- Stack

Threads are lightweight compared to processes.

---

## 4. CPU

CPU (Central Processing Unit) executes instructions.

Think of it as the "brain" of the computer.

The CPU does not understand Java.

It only executes machine instructions.

Java code

↓

Bytecode

↓

JVM

↓

Machine Code

↓

CPU executes

---

## 5. Core

A Core is an independent processor inside the CPU.

Example:

A CPU may contain

```
2 cores
4 cores
8 cores
10 cores
16 cores
```

Each core can execute one instruction stream at a time.

Example:

4-core CPU

```
Core 1

Core 2

Core 3

Core 4
```

Each core can execute one thread simultaneously.

---

## 6. Physical Core

A Physical Core is an actual hardware processing unit.

Example

Apple M2

```
8 Physical Cores
```

Intel i7

```
8 Physical Cores
```

These physically exist on the processor.

---

## 7. Logical (Virtual) Core

A Logical Core (sometimes called a Virtual Core) is created using Hyper-Threading (Intel) or Simultaneous Multithreading (SMT).

Example:

```
8 Physical Cores

↓

16 Logical Cores
```

The operating system now thinks there are 16 CPUs available.

Java also sees 16 processors.

---

## 8. Hyper-Threading

Hyper-Threading is Intel's technology that allows one physical core to execute **two hardware threads**.

Without Hyper-Threading

```
4 Physical Cores

↓

4 Logical Cores
```

With Hyper-Threading

```
4 Physical Cores

↓

8 Logical Cores
```

This improves CPU utilization when one thread is waiting for memory or other resources.

Hyper-Threading **does not double performance**.

Typical improvement:

```
20% - 40%
```

depending on workload.

---

# Who Runs Processes and Threads?

Many beginners think Java runs threads.

That is only partially correct.

## Who runs a Process?

The **Operating System (OS)** creates and manages processes.

Responsibilities:

- Process creation
- Memory allocation
- Scheduling
- Protection
- Resource management

Example:

```
Windows

macOS

Linux
```

---

## Who runs Threads?

Java creates threads through the JVM.

But the JVM ultimately asks the Operating System to create native threads.

After that,

the **Operating System's Scheduler** decides:

- Which thread runs
- When it runs
- On which CPU core it runs
- For how long it runs

So Java **does not control execution order**.

The OS scheduler does.

---

# Concurrency vs Parallelism

These two terms are often confused.

## Concurrency

Concurrency means multiple tasks make progress during the same period of time.

They do **not necessarily run at the exact same instant**.

Example:

One CPU Core

```
Task A

↓

Task B

↓

Task A

↓

Task C

↓

Task B
```

The CPU rapidly switches between tasks.

It appears that everything is happening simultaneously.

Only one task executes at any instant.

---

## Parallelism

Parallelism means multiple tasks execute **at the exact same time**.

Requires multiple CPU cores.

Example:

4-Core CPU

```
Core 1 -> Thread A

Core 2 -> Thread B

Core 3 -> Thread C

Core 4 -> Thread D
```

All execute simultaneously.

---

## Summary

| Concurrency | Parallelism |
|-------------|-------------|
| One or more tasks make progress together | Multiple tasks execute at the exact same time |
| Can happen on a single core | Requires multiple cores |
| Uses Context Switching | Uses multiple CPU cores |
| Improves responsiveness | Improves throughput |

---

# Context Switching

A CPU Core can execute only one thread at a time.

Suppose we have

```
Core 1

Thread A
Thread B
Thread C
```

The CPU rapidly switches between them.

```
A

↓

B

↓

C

↓

A

↓

B
```

Every switch requires saving:

- Registers
- Program Counter
- Stack Pointer

and restoring another thread's state.

This operation is called

**Context Switching**

Context Switching is **not free**.

It has overhead.

Too much context switching can make the application slower.

---

# Thread Count and the Sweet Spot

Many beginners think:

```
More Threads = Faster Program
```

This is false.

Example:

Suppose your CPU has

```
8 Logical Cores
```

Creating

```
8 Threads
```

usually gives excellent utilization for CPU-bound work.

Creating

```
500 Threads
```

does **not** make the CPU 60x faster.

Instead,

the operating system constantly performs context switching.

This wastes CPU time.

---

## CPU-Bound Tasks

Examples

- Sorting
- Matrix multiplication
- Image processing
- Encryption

Ideal thread count is approximately:

```
Number of Logical Cores
```

---

## I/O-Bound Tasks

Examples

- Database
- REST APIs
- File Reading
- Network Calls

Threads often spend time waiting.

More threads than CPU cores can improve throughput because while one thread waits, another thread can execute.

---

## Sweet Spot

General recommendation

CPU-bound

```
Threads ≈ Number of Logical Cores
```

I/O-bound

```
Threads > Number of Cores
```

The exact number depends on:

- Wait time
- CPU usage
- Memory
- Workload

This is one reason modern Java applications prefer **Thread Pools** over creating thousands of threads manually.

---

# Checking CPU Cores

## Java Code

```java
public class ProcessorInfo {

    public static void main(String[] args) {

        int processors = Runtime.getRuntime().availableProcessors();

        System.out.println("Available Logical Processors: " + processors);
    }
}
```

Example Output

```
Available Logical Processors: 8
```

This returns the number of **Logical (Virtual) Cores**, not physical cores.

---

## macOS

Open

```
Activity Monitor

↓

CPU Tab
```

or

```
Apple Menu

↓

About This Mac

↓

More Info
```

You can also run

```bash
sysctl -n hw.physicalcpu
```

Physical cores

```bash
sysctl -n hw.logicalcpu
```

Logical cores

---

## Windows

Open

```
Task Manager

↓

Performance

↓

CPU
```

You will see

- Cores
- Logical Processors

---

# Key Concept: Threads Only Understand Tasks

**Important:** Threads in Java don't directly understand arbitrary code. They only understand **tasks** - implementations of the `Runnable` interface. Any work you want a thread to perform must be wrapped in a class that implements `Runnable`.

---

# The 4-Step Thread Creation Process

## Step 1: Create a Class for the Work

```java
public class MyTask {

    public void doWork() {
        System.out.println("Doing some work...");
    }
}
```

---

## Step 2: Convert it into a Runnable Task

```java
public class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Doing some work...");
    }
}
```

---

## Step 3: Hand Over the Task to a Thread

```java
Runnable task = new MyTask();

Thread thread = new Thread(task);
```

---

## Step 4: Start the Thread

```java
thread.start(); // Correct

// thread.run(); // Wrong
```

Calling `start()` creates a new thread of execution.

Calling `run()` directly simply invokes a normal method in the current thread.

---

# Files in This Package

## 1. ThreadCreationDemo.java

Demonstrates:

- Sequential execution
- Parallel execution
- Traditional thread creation

---

## 2. SequentialNumberPrinter.java

Demonstrates:

- Runnable implementation
- Sleep
- Sequential execution
- InterruptedException handling

---

## 3. SingleNumberPrinter.java

Demonstrates:

- Thousands of thread objects
- Different Runnable instances
- Non-deterministic scheduling

---

# Running the Code

Compile

```bash
javac src/traditionalThreadCreation/*.java
```

Run

```bash
java -cp src traditionalThreadCreation.ThreadCreationDemo
```

---

# Output Examples

Example 1

```
--- Sequential Number Printing ---

Number: 0

Number: 1

Number: 2
...
```

Example 2

```
Creating 1000 Threads...

Number: 18

Number: 2

Number: 901

Number: 53
...
```

Every execution will produce a different ordering because the OS scheduler decides which thread executes first.

---

# Important Concepts

## start() vs run()

Correct

```java
thread.start();
```

Incorrect

```java
thread.run();
```

`start()` creates a new execution path.

`run()` behaves like a normal method call.

---

## Thread Scheduling

Java **does not guarantee execution order**.

The Operating System Scheduler decides:

- Which thread runs first
- Which thread pauses
- Which core executes a thread

---

## InterruptedException

Thrown when a sleeping or waiting thread is interrupted.

A common pattern is:

```java
catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
```

This preserves the interruption status.

---

# Common Pitfalls

### Calling run()

```java
thread.run();
```

Wrong.

---

### Forgetting Runnable

```java
Thread t = new Thread(nonRunnableObject);
```

Compile Error.

---

### Throwing Checked Exceptions

```java
@Override
public void run() throws IOException
```

Compile Error.

---

### Assuming Sequential Execution

```java
for (...) {

    new Thread(...).start();
}
```

Creation order is **not execution order**.

---

### Creating Too Many Threads

Creating thousands of threads for CPU-bound work usually hurts performance because of excessive context switching.

Prefer `ExecutorService` and thread pools for real-world applications.

---

# Thread Lifecycle

```
NEW
        │
        ▼
RUNNABLE
        │
        ▼
RUNNING
        │
 ┌──────┴─────────┐
 ▼                ▼
WAITING      TIMED_WAITING
 ▼                ▼
 └──────┬─────────┘
        ▼
RUNNABLE
        │
        ▼
TERMINATED
```

---

# Further Reading

- Java Concurrency
- ExecutorService
- Thread Pools
- Callable & Future
- CompletableFuture
- ForkJoinPool
- Virtual Threads (Java 21+)

---

# Summary

After completing this package, you should understand:

- What a Program is
- What a Process is
- What a Thread is
- How CPUs execute instructions
- What CPU Cores are
- Difference between Physical and Logical Cores
- Hyper-Threading / SMT
- Who schedules Processes and Threads
- Concurrency vs Parallelism
- Context Switching
- Why too many threads can reduce performance
- Choosing the right thread count
- Checking available CPU cores in Java
- Traditional Thread Creation using Runnable
- Thread Lifecycle
- Common Multithreading Pitfalls

This knowledge forms the foundation required before moving on to **ExecutorService**, **Thread Pools**, **Callable/Future**, **CompletableFuture**, and advanced Java concurrency utilities.

## Further Reading

- [Java Thread Documentation](https://docs.oracle.com/javase/tutorial/essential/concurrency/)
- [Runnable Interface](https://docs.oracle.com/javase/10/docs/api/java/lang/Runnable.html)
- Advanced topics: ThreadPools, ExecutorService, Futures, and Lambdas
