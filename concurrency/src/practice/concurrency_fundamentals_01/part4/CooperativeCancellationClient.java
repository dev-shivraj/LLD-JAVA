package practice.concurrency_fundamentals_01.part4;

public class CooperativeCancellationClient {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            try {
                while(!Thread.currentThread().isInterrupted()) {
                    System.out.println("Worker is working");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }, "worker");

        worker.start();

        Thread.sleep(2000);

        worker.interrupt();

    }
}
