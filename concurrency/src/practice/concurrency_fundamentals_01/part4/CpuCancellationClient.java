package practice.concurrency_fundamentals_01.part4;

public class CpuCancellationClient {
    public static void performCalculation() throws InterruptedException {
        System.out.println("Performing some intensive calculation");
        for(long i = 1; i <= 100_000_0_000L; ++i) {
            int a = 10;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    performCalculation();
                }
                System.out.println("Thread.currentThread().isInterrupted(): " + Thread.currentThread().isInterrupted());
            } catch (InterruptedException e) {
                System.out.println("worker interrupted!");
            }
        }, "worker");

        worker.start();

        Thread.sleep(2000);

        worker.interrupt();

        worker.join();
    }
}
