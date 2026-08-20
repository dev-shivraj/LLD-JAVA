package practice.concurrency_fundamentals_01.part4;

public class JoinClient {
    public static void main(String[] args) throws InterruptedException {
        Thread paymenWorker = new Thread(() -> {
            System.out.println("Payment Worker started");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Payment worker interrupted");
            }
            System.out.println("Payment worker finished");
        }, "payment-worker");

        Thread inventoryWorker = new Thread(() -> {
            System.out.println("Worker started");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Inventory worker interrupted");
            }
            System.out.println("Worker finished");
        }, "inventory-worker");

        Thread notificationWorker = new Thread(() -> {
            System.out.println("Notification worker started");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Notification worker interrupted");
            }
            System.out.println("Notification worker finished");
        }, "notification-worker");


        paymenWorker.start();
        inventoryWorker.start();
        notificationWorker.start();

        paymenWorker.join();
        inventoryWorker.join();
        notificationWorker.join();

        System.out.println("All workers completed");
    }
}
