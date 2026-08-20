package practice.concurrency_fundamentals_01.part3;

public class ExecutionOrderExperimentClient {
    public static void main(String[] args) {
        Thread worker1 = new Thread(() -> {
            for (int i = 1; i <= 10; ++i) {
                System.out.println(Thread.currentThread().getName() + " executing : " + i);
            }
        }, "worker-1");

        Thread worker2 = new Thread(() -> {
            for (int i = 1; i <= 10; ++i) {
                System.out.println(Thread.currentThread().getName() + " executing : " + i);
                Thread.yield();
            }
        }, "worker-2");

        Thread worker3 = new Thread(() -> {
            for (int i = 1; i <= 10; ++i) {
                System.out.println(Thread.currentThread().getName() + " executing : " + i);
            }
        }, "worker-3");

        Thread worker4 = new Thread(() -> {
            for (int i = 1; i <= 10; ++i) {
                System.out.println(Thread.currentThread().getName() + " executing : " + i);
            }
        }, "worker-4");

        Thread worker5 = new Thread(() -> {
            for (int i = 1; i <= 10; ++i) {
                System.out.println(Thread.currentThread().getName() + " executing : " + i);
                Thread.yield();
            }
        }, "worker-5");


        worker1.setPriority(Thread.MAX_PRIORITY);
        worker2.setPriority(Thread.MIN_PRIORITY);
        worker3.setPriority(Thread.NORM_PRIORITY);
        worker4.setPriority(Thread.MAX_PRIORITY);
        worker5.setPriority(Thread.MIN_PRIORITY);



        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();
        worker5.start();



    }
}
