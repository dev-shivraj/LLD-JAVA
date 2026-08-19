package practice.concurrency_fundamentals_01.part1;

public class ThreadNameClient {
    public static void main(String[] args) {
        System.out.println("Main thread : " + Thread.currentThread().getName());

        Thread thread = new Thread(() -> {
            System.out.println("Worker thread : " + Thread.currentThread().getName());
        });



        // giving thread a name
        Thread thread1 = new Thread(() -> {
            System.out.println("Worker thread : " + Thread.currentThread().getName());
        }, "payment-worker");

        thread.start();
        thread1.start();
    }
}
