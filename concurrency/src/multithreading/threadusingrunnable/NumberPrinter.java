package multithreading.threadusingrunnable;

public class NumberPrinter implements Runnable {
    public void printNumbers() throws InterruptedException {
        for(int i = 1; i <= 100; i++) {
            // Sleep for 100 milliseconds to simulate some work being done
            Thread.sleep(100);
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        try {
            printNumbers();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
