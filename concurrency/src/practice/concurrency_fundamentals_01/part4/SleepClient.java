package practice.concurrency_fundamentals_01.part4;

import java.sql.Time;

public class SleepClient {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            System.out.println("Worker started");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Worker interrupted");
            }
            System.out.println("Worker finished");
        }, "worker");

        long start = System.currentTimeMillis();

        worker.start();
        worker.join();

        long end = System.currentTimeMillis();

        System.out.println("Elapsed time: " + (end - start) + " ms");
    }
}
