package multithreading.threadusingrunnable;

public class SingleNumberPrinter implements Runnable {
    private int number;

    public SingleNumberPrinter(int number) {
        this.number = number;
    }

    public void printNumber() throws InterruptedException {
        // Simulate some work with Thread.sleep
        Thread.sleep(1000);
        System.out.println("Number: " + number + " printed by thread: " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        try {
            printNumber();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
