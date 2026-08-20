package practice.concurrency_fundamentals_01.part2;

public class PaymentWorkerStateClient {
    public static void main(String[] args) throws InterruptedException {
        Thread worker1 = new Thread(() -> {
            try {
                System.out.println("Worker 1 : processing started");
                Thread.sleep(2000);
                System.out.println("Worker 1 : processing finished");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "payment-worker-1");

        Thread worker2 = new Thread(() -> {
            try {
                System.out.println("Worker 2 : processing started");
                Thread.sleep(2000);
                System.out.println("Worker 2 : processing finished");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "payment-worker-2");

        Thread worker3 = new Thread(() -> {
            try {
                System.out.println("Worker 3 : processing started");
                Thread.sleep(2000);
                System.out.println("Worker 3 : processing finished");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "payment-worker-3");


        System.out.println("Worker 1 initial state : " + worker1.getState());
        System.out.println("Worker 2 initial state : " + worker2.getState());
        System.out.println("Worker 3 initial state : " + worker3.getState());
        System.out.println("--------------------------------------------------");

        worker1.start();
        worker2.start();
        worker3.start();


        System.out.println("Worker 1 state after start : " + worker1.getState());
        System.out.println("Worker 2 state after start : " + worker2.getState());
        System.out.println("Worker 3 state after start : " + worker3.getState());
        System.out.println("--------------------------------------------------");

        Thread.sleep(200);

        System.out.println("Worker 1 state while waiting 2 sec : " + worker1.getState());
        System.out.println("Worker 2 state while waiting 2 sec : " + worker2.getState());
        System.out.println("Worker 3 state while waiting 2 sec : " + worker3.getState());
        System.out.println("--------------------------------------------------");


        worker1.join();
        worker2.join();
        worker3.join();

        System.out.println("Worker 1 state after completion of the task : " + worker1.getState());
        System.out.println("Worker 2 state after completion of the task : " + worker2.getState());
        System.out.println("Worker 3 state after completion of the task : " + worker3.getState());
        System.out.println("--------------------------------------------------");
    }
}
