package multithreading.threadusingrunnable;

public class SingleNumberPrinter implements Runnable {
    private int number;

    public SingleNumberPrinter(int number) {
        this.number = number;
    }

    public void printNumber() {
        System.out.println("Number: " + number + " printed by thread: " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        printNumber();
    }
}
