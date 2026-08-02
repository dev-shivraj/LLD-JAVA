# 4 steps to implement multithreading in your application:
1. **Create the task in a seperate class files**
2. **Make that task as Runnable by implementing the Runnable interface**
3. **Handover that task to Thread**
4. **Start the Thread**


# Example :
**Step 1 :**
```java
// Step 1: Create the task in a separate class file
public class MyTask {
    public void doSomething() {
        System.out.println("Task is running in a separate thread.");
    }
}

```
**Step 2 :**
```java

// Step 2: Make that task as Runnable by implementing the Runnable interface
public class MyTask implements Runnable {

    public void doSomething() {
        System.out.println("Task is running in a separate thread.");
    }
    
    
    @Override
    public void run() {
        doSomething();
    }
}
```

**Step 3 : in Client class: handover the task to Thread by passing the task object to Thread constructor**
```java
public class Main {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task);       
    }
}
```

**Step 4 : in Client class: start the thread using start() method**

*Note: The `start()` method is used to begin the execution of the thread. It calls the `run()` method internally.*
We should not call the `run()` method directly, as it will not create a new thread and its lifecycle and it will execute the task in the current thread instead.*
```java
public class Main {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task);
        thread.start(); // Start the thread
    }
}
```
