package multithreading.threadusingthreadpool.cachedthreadpool;

public class SingleNumberPrinter implements Runnable {
    private int number;

    public SingleNumberPrinter(int number) {
        this.number = number;
    }

    public void printNumber() throws InterruptedException {
        Thread.sleep(1000); // Simulate some work with sleep
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
