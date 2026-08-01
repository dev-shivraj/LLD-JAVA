package traditionalThreadCreation;

/**
 * Task Definition: A Runnable implementation that prints a single number.
 * 
 * This class demonstrates STEP 1 & 2 of thread creation:
 * - STEP 1: Create a class for the work you want to be done
 * - STEP 2: Implement Runnable interface to convert it into a task
 * 
 * This example shows how each thread gets its own instance of this task,
 * allowing parallel execution of the same work with different data.
 */
public class SingleNumberPrinter implements Runnable {
    
    private final int numberToPrint;

    /**
     * Constructor that initializes the task with a specific number to print.
     * 
     * @param numberToPrint the number that this thread will print
     */
    public SingleNumberPrinter(int numberToPrint) {
        this.numberToPrint = numberToPrint;
    }

    /**
     * Entry point for the thread. Prints the assigned number along with thread info.
     * 
     * This method is called when the thread starts (via Thread.start()).
     * It executes in a separate thread context, allowing concurrent execution.
     */
    @Override
    public void run() {
        System.out.println("Number: " + numberToPrint + " | Thread: " + Thread.currentThread().getName());
    }
}
