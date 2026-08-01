# Traditional Thread Creation in Java

## Overview
This package demonstrates the fundamental concepts of creating and managing threads in Java using the traditional `Runnable` interface approach. It covers the essential 4-step process required to create and execute threads in a concurrent Java application.

---

## Key Concept: Threads Only Understand Tasks

**Important:** Threads in Java don't directly understand arbitrary code. They only understand **tasks** - which are implementations of the `Runnable` interface. Any work you want a thread to perform must be wrapped in a class that implements `Runnable`.

---

## The 4-Step Thread Creation Process

### Step 1: Create a Class for the Work
Define a class that represents the work you want to be executed in a separate thread.

```java
public class MyTask {
    public void doWork() {
        System.out.println("Doing some work...");
    }
}
```

### Step 2: Convert to a Task (Implement Runnable)
Make your class implement the `Runnable` interface to give it a contract with the Thread framework. This requires implementing the `run()` method.

```java
public class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Doing some work...");
    }
}
```

### Step 3: Hand Over the Task to a Thread
Create a new `Thread` object and pass an instance of your Runnable to its constructor.

```java
Runnable task = new MyTask();
Thread thread = new Thread(task);
```

### Step 4: Start the Thread
Call the `start()` method on the thread. This initiates the thread's lifecycle and internally calls the `run()` method.

```java
thread.start();  // Correct: starts thread lifecycle
// thread.run();  // Wrong: executes run() in current thread
```

---

## Files in This Package

### 1. **ThreadCreationDemo.java** (Main Entry Point)
Demonstrates both examples of thread creation:
- **Example 1:** Sequential number printing (single thread with delays)
- **Example 2:** Parallel number printing (1000 concurrent threads)

This is the main class to run for a complete demonstration of thread creation.

### 2. **SequentialNumberPrinter.java**
A `Runnable` implementation that prints numbers 0-99 sequentially with a 1-second delay between each number. This demonstrates:
- How to implement the Runnable interface
- How a single thread executes a task from start to finish
- How to handle InterruptedException

### 3. **SingleNumberPrinter.java**
A lightweight `Runnable` implementation that prints a single number. This demonstrates:
- Creating multiple threads with different task instances
- Parallel execution of similar tasks with different data
- How thread scheduling is non-deterministic (output order is unpredictable)

---

## Running the Code

### Compile:
```bash
javac src/traditionalThreadCreation/*.java
```

### Run:
```bash
java -cp src/ traditionalThreadCreation.ThreadCreationDemo
```

---

## Output Examples

### Expected Behavior:

**Example 1 Output:**
```
--- Example 1: Sequential Number Printing ---
Number: 0 | Thread: Thread-0
Number: 1 | Thread: Thread-0
Number: 2 | Thread: Thread-0
...
(Takes ~100 seconds due to 1-second delays)
```

**Example 2 Output:**
```
--- Example 2: Parallel Number Printing ---
Creating 1000 threads, each printing one unique number...
Number: 5 | Thread: Thread-5
Number: 15 | Thread: Thread-15
Number: 3 | Thread: Thread-3
Number: 1 | Thread: Thread-1
...
(All threads start immediately, but order is non-deterministic)
```

**Note:** The output order in Example 2 varies each run due to operating system thread scheduling.

---

## Important Concepts

### start() vs run()
- **`thread.start()`** - Correct. Initiates the thread lifecycle in a separate execution context
- **`thread.run()`** - Wrong when used directly. Executes the method in the current thread (no concurrency)

### Thread Scheduling
- Thread execution order is determined by the OS scheduler, not creation order
- You cannot assume threads execute in a specific sequence
- All threads created in Example 2 start nearly simultaneously

### InterruptedException
- Thrown when a thread's sleep is interrupted
- Should be handled carefully to preserve thread interruption status
- In this package, we re-interrupt the thread if it's interrupted during sleep

---

## Common Pitfalls to Avoid

1. **Calling run() instead of start()**
   ```java
   thread.run();   // WRONG - runs in current thread
   thread.start(); // CORRECT - runs in new thread
   ```

2. **Forgetting to implement Runnable**
   ```java
   // Thread expects Runnable, not arbitrary classes
   Thread t = new Thread(nonRunnableObject); // Won't compile
   ```

3. **Throwing checked exceptions from run()**
   ```java
   // run() can't throw checked exceptions
   @Override
   public void run() throws IOException { } // Compile error
   ```

4. **Assuming sequential execution**
   ```java
   // Creating threads in a loop doesn't guarantee sequential execution
   for(int i = 0; i < 1000; i++) {
       // Threads will likely execute out of order
   }
   ```

---

## Thread Lifecycle

```
┌─────────────────────────────────────────────┐
│ Thread Lifecycle                            │
├─────────────────────────────────────────────┤
│ 1. New      - Thread created, not started   │
│ 2. Runnable - Thread.start() called         │
│ 3. Running  - Thread executing run()        │
│ 4. Waiting  - Blocked (sleep, join, etc.)   │
│ 5. Dead     - Thread execution complete     │
└─────────────────────────────────────────────┘
```

---

## Further Reading

- [Java Thread Documentation](https://docs.oracle.com/javase/tutorial/essential/concurrency/)
- [Runnable Interface](https://docs.oracle.com/javase/10/docs/api/java/lang/Runnable.html)
- Advanced topics: ThreadPools, ExecutorService, Futures, and Lambdas
