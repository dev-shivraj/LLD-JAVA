# Runnable vs Callable in Java

## ⭐ Runnable vs Callable (Execution Flow)

### Runnable

```
Main Thread
     |
     | execute()
     |
     +-------------------------->
                               Worker Thread
                               |
                               | Do the work
                               |
                               Finished

Main thread continues immediately.
(No waiting)
```

### Callable

```
Main Thread
     |
     | submit()
     |
     +-------------------------->
                               Worker Thread
                               |
                               | Compute Result
                               |
                               Result Ready
                                     ^
                                     |
Future.get() ------------------------+

Future.get() blocks until the result is available.
```

> ## ⭐ Most Important Difference
>
> - **Runnable** is generally **non-blocking** because there is no result to wait for. You simply start the task and continue with other work.
> - **Callable** is often **associated with blocking** because its result is typically retrieved using `Future.get()`, and `get()` **blocks the calling thread until the computation completes**.
>
> **Remember:** The blocking is caused by `Future.get()`, **not by `Callable` itself**.
> 
## Overview

Both **Runnable** and **Callable** represent a task that can be executed by a separate thread. The main difference is **whether you need a result back from the task**.

- Use **Runnable** for tasks that simply perform work.
- Use **Callable** for tasks that perform work **and return a result**.

---

# Quick Decision Rule

| If your task... | Use |
|-----------------|-----|
| Doesn't return anything | `Runnable` |
| Returns a value | `Callable` |
| Needs to throw checked exceptions | `Callable` |
| Just performs background work | `Runnable` |
| Performs a computation and returns the answer | `Callable` |

---

# Runnable

## Definition

`Runnable` is a functional interface introduced in **Java 1.0**. It represents a task that **does not return any value**.

```java
@FunctionalInterface
public interface Runnable {
    void run();
}
```

### Characteristics

- Does **not** return any value.
- Cannot throw checked exceptions.
- Suitable for fire-and-forget tasks.
- Can be executed using either `Thread` or `ExecutorService`.

---

## When to Use Runnable

Use `Runnable` when your task simply performs some work and you don't need any result back.

### Common Use Cases

- Logging
- Sending notifications
- Writing to a file
- Updating cache
- Background cleanup
- Printing reports
- Periodic scheduled jobs

---

## Example 1: Using Thread

```java
public class Main {

    public static void main(String[] args) {

        Runnable task = () -> {
            System.out.println("Task is running...");
        };

        Thread thread = new Thread(task);
        thread.start();
    }
}
```

**Output**

```
Task is running...
```

---

## Example 2: Using ExecutorService

```java
ExecutorService executor = Executors.newFixedThreadPool(2);

executor.execute(() -> {
    System.out.println("Processing...");
});

executor.shutdown();
```

---

# Callable

## Definition

`Callable` is a functional interface introduced in **Java 5**.

Unlike `Runnable`, it can:

- Return a value
- Throw checked exceptions

```java
@FunctionalInterface
public interface Callable<V> {
    V call() throws Exception;
}
```

---

## Characteristics

- Returns a value.
- Can throw checked exceptions.
- Executed using an `ExecutorService`.
- Returns the result through a `Future`.

---

## When to Use Callable

Use `Callable` whenever your task performs some computation and the caller needs the result.

### Common Use Cases

- Calculating a sum
- Database queries
- API calls
- Image processing
- File processing
- Searching algorithms
- Machine learning predictions

---

## Example

```java
ExecutorService executor = Executors.newFixedThreadPool(2);

Callable<Integer> task = () -> {
    return 10 + 20;
};

Future<Integer> future = executor.submit(task);

System.out.println(future.get());

executor.shutdown();
```

**Output**

```
30
```

---

# Runnable vs Callable

| Feature | Runnable | Callable |
|----------|----------|----------|
| Introduced In | Java 1.0 | Java 5 |
| Method | `run()` | `call()` |
| Returns Value | ❌ No | ✅ Yes |
| Return Type | `void` | Generic (`T`) |
| Throws Checked Exceptions | ❌ No | ✅ Yes |
| Can be used with Thread | ✅ Yes | ❌ No |
| Can be used with ExecutorService | ✅ Yes | ✅ Yes |
| Returns Future | ❌ No | ✅ Yes |

---

# Real World Analogy

Imagine you are a manager assigning work to employees.

## Runnable

Manager:

> "Please clean the meeting room."

Employee cleans the room.

No response is expected.

```
Manager
    |
    |  Clean the room
    |
Employee
```

---

## Callable

Manager:

> "Calculate today's total sales and tell me the amount."

Employee calculates and returns the answer.

```
Manager
    |
    | Calculate Sales
    |
Employee
    |
    | ₹52,340
    |
Manager
```

---

# Can Runnable Return a Value?

No.

This will produce a compilation error.

```java
Runnable task = () -> {
    return 5;
};
```

Reason:

`run()` has a return type of `void`.

---

# Can Callable Return Nothing?

Yes.

Use `Callable<Void>`.

```java
Callable<Void> task = () -> {

    System.out.println("Running...");

    return null;
};
```

Although possible, if no result is required, `Runnable` is the better choice.

---

# Exception Handling

## Runnable

`run()` cannot declare checked exceptions.

```java
Runnable task = () -> {

    try {
        throw new IOException();
    } catch (IOException e) {
        e.printStackTrace();
    }

};
```

You must handle checked exceptions inside the task.

---

## Callable

`call()` can throw checked exceptions.

```java
Callable<String> task = () -> {

    if (true)
        throw new IOException("File not found");

    return "Success";
};
```

When retrieving the result,

```java
future.get();
```

the exception is wrapped inside an `ExecutionException`.

```java
try {

    future.get();

} catch (ExecutionException e) {

    Throwable actualException = e.getCause();

}
```

---

# Which Method Should You Use?

## Use Runnable

✔ No return value needed

✔ Background processing

✔ Logging

✔ Notifications

✔ Cache updates

✔ File writing

✔ Fire-and-forget tasks

---

## Use Callable

✔ Need a result

✔ Heavy computation

✔ Database query

✔ API request

✔ Image processing

✔ Mathematical calculations

✔ Any task whose output is required

---

# Complete Example

```java
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws Exception {

        ExecutorService executor =
                Executors.newFixedThreadPool(2);

        // Runnable
        Runnable runnableTask = () ->
                System.out.println("Runnable executed");

        executor.execute(runnableTask);

        // Callable
        Callable<Integer> callableTask = () -> {

            int sum = 0;

            for (int i = 1; i <= 10; i++) {
                sum += i;
            }

            return sum;
        };

        Future<Integer> future =
                executor.submit(callableTask);

        System.out.println("Sum = " + future.get());

        executor.shutdown();
    }
}
```

**Output**

```
Runnable executed
Sum = 55
```

---

# Decision Flow

```
                  Is there a task?
                        |
                        |
                        v
          Do you need a result back?
               /                 \
             No                   Yes
             |                     |
             v                     v
       Use Runnable          Use Callable
             |                     |
             |                     |
      execute()             submit()
                                   |
                                   v
                             Future<T>
```

---

# Best Practices

- Prefer **Runnable** when no return value is required.
- Prefer **Callable** whenever a result is expected.
- Use `ExecutorService` instead of creating raw `Thread` objects for most applications.
- Always call `shutdown()` (or `shutdownNow()` when appropriate) on the `ExecutorService`.
- Use `Future.get()` only when you actually need the result, as it blocks until the task completes.
- Handle `InterruptedException` and `ExecutionException` when working with `Future`.

---

# Interview Summary

| Question | Answer |
|----------|--------|
| When should you use Runnable? | When no return value is required. |
| When should you use Callable? | When the task must return a value or throw checked exceptions. |
| Which method does Runnable define? | `run()` |
| Which method does Callable define? | `call()` |
| Which one returns a `Future`? | `Callable` (via `ExecutorService.submit()`) |
| Can Callable throw checked exceptions? | Yes |
| Can Runnable throw checked exceptions? | No |

---

# Easy Way to Remember

```
Runnable
---------
Do the work.

Callable
---------
Do the work
+
Give me the result.
```

Or simply:

- **Runnable → `run()` → `void`**
- **Callable → `call()` → returns `T` through `Future<T>`**