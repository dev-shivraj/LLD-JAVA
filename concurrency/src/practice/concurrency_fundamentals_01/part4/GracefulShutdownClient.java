package practice.concurrency_fundamentals_01.part4;

public class GracefulShutdownClient {
    public static void main(String[] args) throws InterruptedException {
        Thread paymentWorker = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Payment worker is processing");
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                System.out.println("Payment worker is interrupted");
                Thread.currentThread().interrupt();
                System.out.println("Payment worker cleanup done");
            }
        }, "payment-worker");

        Thread emailWorker = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Email worker is processing");
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                System.out.println("Email worker is interrupted");
                Thread.currentThread().interrupt();
                System.out.println("Email worker cleanup done");
            }
        }, "email-worker");

        Thread reportWorker = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Report worker is processing");
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                System.out.println("Report worker is interrupted");
                Thread.currentThread().interrupt();
                System.out.println("Report worker cleanup done");
            }
        }, "report-worker");

        Thread auditWorker = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Audit worker is processing");
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                System.out.println("Audit worker is interrupted");
                Thread.currentThread().interrupt();
                System.out.println("Audit worker cleanup done");
            }
        }, "audit-worker");


        paymentWorker.start();
        emailWorker.start();
        reportWorker.start();
        auditWorker.start();


        Thread.sleep(2000);

        System.out.println("-------------------------------------");

        System.out.println("Shutdown requested");

        paymentWorker.interrupt();
        emailWorker.interrupt();
        reportWorker.interrupt();
        auditWorker.interrupt();

        System.out.println("-------------------------------------");

        paymentWorker.join();
        emailWorker.join();
        reportWorker.join();
        auditWorker.join();

        System.out.println("-------------------------------------");

        System.out.println("Application shutdown completed!");

    }
}
