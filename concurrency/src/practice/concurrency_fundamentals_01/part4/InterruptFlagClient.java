package practice.concurrency_fundamentals_01.part4;

public class InterruptFlagClient {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Worker is working...");
            }
            System.out.println("Worker noticed interruption");
        });

        worker.start();
        Thread.sleep(100);

        System.out.println("Main interrupting worker");

        worker.interrupt();
        worker.join();

        System.out.println("Main finished");
    }
}