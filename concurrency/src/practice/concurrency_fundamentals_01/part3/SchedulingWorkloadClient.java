package practice.concurrency_fundamentals_01.part3;

public class SchedulingWorkloadClient {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> doWork("A"));
        Thread t2 = new Thread(() -> doWork("B"));
        Thread t3 = new Thread(() -> doWork("C"));

        t1.start();
        t2.start();
        t3.start();
    }

    private static void doWork(String name) {
        for (int i = 1; i <= 10; i++) {
            long result = 0;
            for (long j = 0; j < 10_000_000L; j++) {
                result += j;
            }
            System.out.println(name + " completed iteration " + i);
        }
    }
}