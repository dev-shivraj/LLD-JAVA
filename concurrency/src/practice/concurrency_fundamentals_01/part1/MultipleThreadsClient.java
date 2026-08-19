package practice.concurrency_fundamentals_01.part1;

public class MultipleThreadsClient {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; ++i) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }, "worker-thread-1");

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5; ++i) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }, "worker-thread-2");

        thread1.start();
        thread2.start();
    }
}
