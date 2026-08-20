package practice.concurrency_fundamentals_01.part4;

public class InterruptSleepClient {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            try {
                System.out.println("Worker going to sleep");
                Thread.sleep(10_000);
                System.out.println("Worker woke normally");
            } catch (InterruptedException e) {
                System.out.println("Worker was interrupted");
            }
        });

        worker.start();
        Thread.sleep(1000);

        System.out.println("Main interrupting worker");

        worker.interrupt();
        worker.join();

        System.out.println("Main finished");
    }
}