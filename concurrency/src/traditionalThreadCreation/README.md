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

It starts with the basics of a program, process, thread, and CPU architecture, then builds up to real thread creation examples. The goal is to show not just *how* to start a thread, but *what is actually happening* when Java code runs on your machine.

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

If you only remember one thing from this package, remember this:

```java
Thread thread = new Thread(new SequentialNumberPrinter());
thread.start();
```

The `Runnable` is the task, and the `Thread` is the worker that executes that task.

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

Think of it as a recipe written in a book. The recipe exists, but nothing is being cooked yet.

Example:

```
Calculator.exe
```

Until you open it, it is only a program.

More examples:

- `ThreadCreationDemo.java` before compilation
- `MyApp.jar` sitting in your downloads folder
- An `.exe` file that has not been launched yet

Once the JVM or OS starts executing it, the program becomes an active process.

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

That isolation is important: if one process crashes, other processes usually keep running. For example, if one browser window freezes, it does not necessarily crash your music player or your IDE.

Example:

```
Chrome
Spotify
VS Code
IntelliJ
```

Each is a separate process.

Practical examples:

- Opening Chrome twice can create multiple browser processes
- Running the same Java application from two terminals creates two separate processes
- Starting IntelliJ IDEA and Spotify at the same time gives you two independent processes

Each process gets its own memory space, so processes do not share objects directly.

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

Example in a Java application:

- `main` thread: starts the program
- worker thread: prints numbers in the background
- timer thread: wakes up every few seconds

All of them belong to the same process, but they can move forward independently.

Thread example in this package:

```java
Runnable task = new SequentialNumberPrinter();
Thread thread = new Thread(task);
thread.start();
```

---

## 4. CPU

CPU (Central Processing Unit) executes instructions.

Think of it as the "brain" of the computer.

The CPU does not understand Java.

It only executes machine instructions.

That is why Java source code must go through compilation and runtime translation before the CPU can execute it.

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

In simple terms, more cores mean the CPU has more workers available at the same time.

Example:

4-core CPU

```
Core 1

Core 2

Core 3

Core 4
```

Each core can execute one thread simultaneously.

Example:

- 2-core CPU: can often run 2 CPU-heavy tasks at once
- 4-core CPU: can often run 4 CPU-heavy tasks at once
- 8-core CPU: can often run 8 CPU-heavy tasks at once

The exact behavior still depends on the OS scheduler and the workload.

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

If your CPU says it has 8 physical cores, those are real hardware units on the chip.

Why this matters:

- more physical cores usually help with heavy computation
- physical cores are the real limit before logical cores are considered
- benchmarks often compare physical core counts first

Example:

- Apple M2 may report 8 physical cores
- a desktop Intel CPU might report 6, 8, 12, or more physical cores

The exact count depends on the model.

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

This is why `Runtime.getRuntime().availableProcessors()` may return a number larger than the number of physical cores.

Example:

```java
int processors = Runtime.getRuntime().availableProcessors();
System.out.println(processors);
```

If the machine exposes 16 logical cores, the output may be `16` even when the CPU has only 8 physical cores.

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

Example:

- a video encoder may benefit a lot from extra logical cores
- a memory-heavy workload may see smaller gains
- a lightly loaded desktop app may notice almost no difference

Hyper-Threading is helpful, but it is not a replacement for real physical cores.

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

The JVM itself runs inside a process. The OS still allocates memory, enforces isolation, and decides when a process gets CPU time.

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

Example:

- you call `thread.start()` in Java
- the JVM asks the OS to create a native thread
- the OS decides when that thread actually runs

That is why two runs of the same program can print output in different orders.

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

Practical example:

- one core renders a frame
- another core compresses data
- another core handles a database query
- another core updates the UI

Parallelism is about *doing many tasks at the same time*.

---

## Summary

| Concurrency | Parallelism |
|-------------|-------------|
| One or more tasks make progress together | Multiple tasks execute at the exact same time |
| Can happen on a single core | Requires multiple cores |
| Uses Context Switching | Uses multiple CPU cores |
| Improves responsiveness | Improves throughput |

You can have concurrency without parallelism, but parallelism usually implies concurrency.

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

Example:

- a web server with too many worker threads may spend more time switching than doing useful work
- a CPU-heavy batch job with too many threads can slow down because every core keeps interrupting work to manage scheduling

That is why thread count matters.

---

# Thread Count and the Sweet Spot

Many beginners think:

```
More Threads = Faster Program
```

This is false.

The best thread count depends on the kind of work.

Rule of thumb:

- CPU-bound work: threads close to the number of logical cores
- I/O-bound work: more threads can help because many threads spend time waiting
- mixed workloads: measure and tune

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

Example:

If you have 8 logical cores and create 200 threads for a CPU-heavy task, most threads will not run at the same time. Instead, they will compete for CPU time and increase overhead.

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

Examples:

- 4 logical cores -> start testing around 4 CPU-heavy worker threads
- 8 logical cores -> start around 8 threads
- 16 logical cores -> start around 16 threads

This is only a starting point, not a rule.

---

## I/O-Bound Tasks

Examples

- Database
- REST APIs
- File Reading
- Network Calls

Threads often spend time waiting.

More threads than CPU cores can improve throughput because while one thread waits, another thread can execute.

Examples:

- a thread waiting on a network response
- a thread waiting for disk I/O
- a thread waiting for a database query to finish

In these cases, extra threads can keep the CPU busy while some threads are blocked.

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

Example:

- 1,000 short tasks
- 8 logical cores
- a fixed thread pool of 8 or 16 workers is usually easier to manage than 1,000 raw threads

This package uses raw threads for learning, but production code should usually prefer higher-level concurrency utilities.

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

Other useful checks:

```bash
sysctl -n hw.physicalcpu
sysctl -n hw.logicalcpu
```

Use the first command on macOS to see physical cores and the second to see logical cores.

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

This view is useful when you want to compare what the OS reports versus what Java reports.

If you are tuning thread counts, check this before choosing a default number.

---

# Key Concept: Threads Only Understand Tasks

**Important:** Threads in Java don't directly understand arbitrary code. They only understand **tasks** - implementations of the `Runnable` interface. Any work you want a thread to perform must be wrapped in a class that implements `Runnable`.

Example:

```java
Runnable task = () -> System.out.println("Hello from " + Thread.currentThread().getName());
new Thread(task).start();
```

This is the simplest possible task definition.

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

This version only contains the business logic. It does not know anything about threads yet.

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

Now the class can be handed to a `Thread`.

Example:

```java
Runnable task = new MyTask();
```

---

## Step 3: Hand Over the Task to a Thread

```java
Runnable task = new MyTask();

Thread thread = new Thread(task);
```

At this point the task is prepared, but nothing has started yet.

You are simply telling the thread, "When you run, execute this task."

---

## Step 4: Start the Thread

```java
thread.start(); // Correct

// thread.run(); // Wrong
```

Calling `start()` creates a new thread of execution.

Calling `run()` directly simply invokes a normal method in the current thread.

Full example:

```java
Runnable task = new SequentialNumberPrinter();
Thread thread = new Thread(task);
thread.start();
```

If you replace `start()` with `run()`, the code still compiles, but it does not create a new thread.

---

# Files in This Package

## 1. ThreadCreationDemo.java

Demonstrates:

- Sequential execution
- Parallel execution
- Traditional thread creation

It is the main driver for the package. It shows both a single delayed worker and a burst of many short-lived workers so you can see the difference in output ordering.

---

## 2. SequentialNumberPrinter.java

Demonstrates:

- Runnable implementation
- Sleep
- Sequential execution
- InterruptedException handling

It prints numbers one by one with a pause between each number. The delay makes it easier to observe how a thread can stay alive while doing a long-running task.

Example behavior:

```text
Number: 0 | Thread: Thread-0
Number: 1 | Thread: Thread-0
Number: 2 | Thread: Thread-0
```

---

## 3. SingleNumberPrinter.java

Demonstrates:

- Thousands of thread objects
- Different Runnable instances
- Non-deterministic scheduling

Each task prints one number and finishes immediately. Because the threads are started in a loop, the output order depends entirely on scheduling.

Example behavior:

```text
Number: 42 | Thread: Thread-12
Number: 7 | Thread: Thread-9
Number: 99 | Thread: Thread-18
```

---

# Running the Code

Compile

```bash
javac src/traditionalThreadCreation/*.java
```

If you prefer a separate output directory:

```bash
javac -d out src/traditionalThreadCreation/*.java
```

Run

```bash
java -cp src traditionalThreadCreation.ThreadCreationDemo
```

Or, if you compiled into `out`:

```bash
java -cp out traditionalThreadCreation.ThreadCreationDemo
```

Run from the repository root so the package path resolves correctly.

---

# Output Examples

Example 1

```
--- Sequential Number Printing ---

Number: 0 | Thread: Thread-0

Number: 1 | Thread: Thread-0

Number: 2 | Thread: Thread-0
...
```

This output is ordered because the same thread is printing one number at a time with a delay.

Example 2

```
Creating 1000 Threads...

Number: 18 | Thread: Thread-14

Number: 2 | Thread: Thread-6

Number: 901 | Thread: Thread-39

Number: 53 | Thread: Thread-19
...
```

Every execution will produce a different ordering because the OS scheduler decides which thread executes first.

You may also see different thread names depending on your JVM and whether other threads are already running.

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

Example:

```java
Thread t = new Thread(() -> System.out.println(Thread.currentThread().getName()));
t.start(); // prints a worker thread name
t.run();    // prints the current thread name, usually "main"
```

---

## Thread Scheduling

Java **does not guarantee execution order**.

The Operating System Scheduler decides:

- Which thread runs first
- Which thread pauses
- Which core executes a thread

Example:

```java
for (int i = 0; i < 3; i++) {
    new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
}
```

The printed order may change every time you run it.

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

Example:

```java
try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
```

This is the standard pattern because it avoids silently losing the interruption signal.

---

# Common Pitfalls

### Calling run()

```java
thread.run();
```

Wrong.

Use `start()` when you want a new thread. Use `run()` only when you want to call the method directly like a normal function.

---

### Forgetting Runnable

```java
Thread t = new Thread(nonRunnableObject);
```

Compile Error.

`Thread` needs a task object. If the object does not implement `Runnable`, the constructor cannot accept it.

---

### Throwing Checked Exceptions

```java
@Override
public void run() throws IOException
```

Compile Error.

`Runnable.run()` does not allow checked exceptions in its signature, so you must catch them inside the method.

---

### Assuming Sequential Execution

```java
for (...) {

    new Thread(...).start();
}
```

Creation order is **not execution order**.

Example:

```java
for (int i = 1; i <= 5; i++) {
    new Thread(() -> System.out.println("Running task")).start();
}
```

Even though the loop starts threads in order, the output may appear in any order.

---

### Creating Too Many Threads

Creating thousands of threads for CPU-bound work usually hurts performance because of excessive context switching.

Prefer `ExecutorService` and thread pools for real-world applications.

Example:

- 1,000 short tasks
- 8 logical cores
- a fixed thread pool of 8 or 16 workers is usually easier to manage than 1,000 raw threads

This package uses raw threads for learning, but production code should usually prefer higher-level concurrency utilities.

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

Meaning of the states:

- `NEW`: thread object created, but not started
- `RUNNABLE`: ready to run or currently running
- `RUNNING`: actually executing on a CPU core
- `WAITING`: waiting indefinitely for another thread or signal
- `TIMED_WAITING`: waiting for a specific time, such as `sleep()`
- `TERMINATED`: finished execution

Common transitions:

- `start()` moves `NEW` to `RUNNABLE`
- `sleep()` moves a thread to `TIMED_WAITING`
- `join()` can move a thread to `WAITING`
- finishing `run()` moves the thread to `TERMINATED`

---

# Further Reading

- Java Concurrency
- ExecutorService
- Thread Pools
- Callable & Future
- CompletableFuture
- ForkJoinPool
- Virtual Threads (Java 21+)

Suggested next examples to study:

- thread pools for repeated tasks
- `Callable` when you need return values
- `Future` when you need to wait for results
- `CompletableFuture` for async pipelines
- virtual threads for lightweight concurrency in newer Java versions

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

Try changing the thread count in `ThreadCreationDemo.java` and observe how the output changes on your machine. That hands-on experiment makes the scheduler behavior much easier to understand.

## Additional Resources

- [Java Thread Documentation](https://docs.oracle.com/javase/tutorial/essential/concurrency/)
- [Runnable Interface](https://docs.oracle.com/javase/10/docs/api/java/lang/Runnable.html)
- Advanced topics: ThreadPools, ExecutorService, Futures, and Lambdas
