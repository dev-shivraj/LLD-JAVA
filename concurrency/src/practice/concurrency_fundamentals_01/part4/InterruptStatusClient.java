package practice.concurrency_fundamentals_01.part4;

public class InterruptStatusClient {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            // update the interrupt status to true
            Thread.currentThread().interrupt();

            // it doesn't update the interrupted status, just read the status and return
            // It does not clear the status
            System.out.println("isInterrupted : " + Thread.currentThread().isInterrupted());
            System.out.println("isInterrupted : " + Thread.currentThread().isInterrupted());
            System.out.println("isInterrupted : " + Thread.currentThread().isInterrupted());
            System.out.println("isInterrupted : " + Thread.currentThread().isInterrupted());

            // it interrupts the thread, makes interrupted status to false and return true
            // this is a static method
            System.out.println("interrupted: " + Thread.interrupted());
            System.out.println("interrupted: " + Thread.interrupted());
            System.out.println("interrupted: " + Thread.interrupted());
            System.out.println("interrupted: " + Thread.interrupted());


            System.out.println("isInterrupted: " + Thread.currentThread().isInterrupted());


            System.out.println("Worker noticed interruption");
        });

        worker.start();
        Thread.sleep(100);

        worker.join();

        System.out.println("Main finished");
    }
}
