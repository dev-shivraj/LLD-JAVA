package traditionalThreadCreation;

/**
 * Task Definition: A Runnable implementation that prints numbers sequentially with a delay.
 * 
 * This class demonstrates STEP 1 & 2 of thread creation:
 * - STEP 1: Create a class for the work you want to be done
 * - STEP 2: Implement Runnable interface to convert it into a task
 * 
 * The Thread framework only understands Runnable tasks. This class defines the work
 * that will be executed when a Thread runs it.
 */
public class SequentialNumberPrinter implements Runnable {
    
    private static final int TOTAL_NUMBERS = 100;
    private static final int DELAY_MS = 1000; // 1 second delay between numbers

    /**
     * Prints numbers from 0 to 99 sequentially, with a 1-second delay between each number.
     * 
     * @throws InterruptedException if the thread's sleep is interrupted
     */
    private void printNumbers() throws InterruptedException {
        for (int i = 0; i < TOTAL_NUMBERS; i++) {
            Thread.sleep(DELAY_MS);
            System.out.println("Number: " + i + " | Thread: " + Thread.currentThread().getName());
        }
    }

    /**
     * Entry point for the thread. This method is called when the thread starts.
     * 
     * The run() method is defined by the Runnable interface contract. 
     * The Thread will execute this method in a separate execution context.
     */
    @Override
    public void run() {
        try {
            printNumbers();
        } catch (InterruptedException e) {
            System.err.println("SequentialNumberPrinter was interrupted: " + e.getMessage());
            Thread.currentThread().interrupt(); // Preserve interrupted status
        }
    }
}
