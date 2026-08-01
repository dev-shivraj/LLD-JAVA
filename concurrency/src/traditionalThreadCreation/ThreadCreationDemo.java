package traditionalThreadCreation;

/**
 * ThreadCreationDemo - Demonstrates the 4-step process of creating and running threads in Java.
 * 
 * THREAD CREATION 4-STEP PROCESS:
 * ================================
 * STEP 1: Create a class for the work you want to be done
 *         Example: To print numbers, create a NumberPrinter class
 *
 * STEP 2: Convert the class into a task by implementing Runnable interface
 *         This gives the class a contract with the Thread framework
 *         Runnable only requires implementing: run() method
 *
 * STEP 3: Hand over the task to a Thread
 *         Create a new Thread(task) and pass the Runnable instance
 *
 * STEP 4: Start the thread
 *         Call thread.start() - NOT thread.run()
 *         start() initiates the thread's lifecycle and calls run() internally
 * 
 * KEY POINT: Threads only understand Runnable tasks. Anything you want a thread
 *            to do must be wrapped in a class that implements Runnable.
 */
public class ThreadCreationDemo {
    
    /**
     * Main method demonstrating both examples of thread creation
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== THREAD CREATION DEMO ===\n");
        System.out.println("Main thread: " + Thread.currentThread().getName());

        // Example 1: Single thread executing sequential number printing
        example1_SequentialNumberPrinting();
        
        // Small delay to separate outputs
        Thread.sleep(500);

        System.out.println("\n--- Starting Example 2 ---\n");

        // Example 2: Multiple threads executing in parallel
        example2_ParallelNumberPrinting();
        
        System.out.println("\nMain thread finished: " + Thread.currentThread().getName());
    }
    
    /**
     * Example 1: Single thread that prints numbers sequentially (with delay)
     * 
     * Demonstrates the 4-step process:
     * STEP 1: NumberPrinter class created
     * STEP 2: Implements Runnable (already done in SequentialNumberPrinter)
     * STEP 3: Create Thread and hand over the task
     * STEP 4: Start the thread
     */
    private static void example1_SequentialNumberPrinting() throws InterruptedException {
        System.out.println("--- Example 1: Sequential Number Printing ---");
        System.out.println("Creating a single thread that prints 100 numbers with 1-sec delay...\n");
        
        // STEP 1 & 2: Task class (already created: SequentialNumberPrinter implements Runnable)
        SequentialNumberPrinter task = new SequentialNumberPrinter();
        
        // STEP 3: Hand over task to Thread
        Thread thread = new Thread(task);
        
        // STEP 4: Start the thread
        thread.start();
        
        // Note: We don't join here so main continues, showing concurrent execution
        // If you want to wait for this thread to finish, use: thread.join();
    }
    
    /**
     * Example 2: Multiple threads executing in parallel
     * 
     * Creates 1000 threads, each with its own task instance to print a single number.
     * All threads run concurrently, demonstrating true parallelism.
     * 
     * Demonstrates the 4-step process (repeated for each thread):
     * STEP 1: SingleNumberPrinter class created
     * STEP 2: Implements Runnable (already done in SingleNumberPrinter)
     * STEP 3: Create Thread and hand over the task (in a loop)
     * STEP 4: Start the thread (in a loop)
     */
    private static void example2_ParallelNumberPrinting() {
        System.out.println("--- Example 2: Parallel Number Printing ---");
        System.out.println("Creating 1000 threads, each printing one unique number...\n");
        
        int numberOfThreads = 1000;
        
        for (int i = 1; i <= numberOfThreads; i++) {
            // STEP 1 & 2: Create task (each thread gets its own instance)
            SingleNumberPrinter task = new SingleNumberPrinter(i);
            
            // STEP 3: Hand over task to Thread
            Thread thread = new Thread(task);
            
            // STEP 4: Start the thread
            // Note: All threads will execute almost simultaneously due to OS scheduling
            thread.start();
        }
        
        System.out.println("All " + numberOfThreads + " threads have been started!");
        System.out.println("(Output order depends on OS thread scheduling, not creation order)\n");
    }
}
