package multithreading.threadusingthreadpool.fixedthreadpool;

public class SingleNumberPrinter implements Runnable {
    private int number;

    public SingleNumberPrinter(int number) {
        this.number = number;
    }

    public void printNumber() throws InterruptedException {
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
