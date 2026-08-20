package practice.concurrency_fundamentals_01.part3;

public class ThreadPriorityClient {
    public static void main(String[] args) {
        Thread low_priority_worker = new Thread(() -> {
            for (int i = 1; i <= 10; ++i) {
                System.out.println(Thread.currentThread().getName() + "executing : " + i);
            }
        }, "low-priority");

        Thread normal_priority_worker = new Thread(() -> {
            for (int i = 1; i <= 10; ++i) {
                System.out.println(Thread.currentThread().getName() + "executing : " + i);
            }
        }, "normal-priority");

        Thread high_priority_worker = new Thread(() -> {
            for (int i = 1; i <= 10; ++i) {
                System.out.println(Thread.currentThread().getName() + "executing : " + i);
            }
        }, "high-priority");


        low_priority_worker.setPriority(Thread.MIN_PRIORITY);
        normal_priority_worker.setPriority(Thread.NORM_PRIORITY);
        high_priority_worker.setPriority(Thread.MAX_PRIORITY);

        low_priority_worker.start();
        normal_priority_worker.start();
        high_priority_worker.start();
    }
}
