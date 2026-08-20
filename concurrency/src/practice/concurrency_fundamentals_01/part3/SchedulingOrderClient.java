package practice.concurrency_fundamentals_01.part3;

public class SchedulingOrderClient {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                System.out.println("A-" + i);
            }
        }, "worker-A");

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                System.out.println("B-" + i);
            }
        }, "worker-B");

        Thread t3 = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                System.out.println("C-" + i);
            }
        }, "worker-C");


        t1.start();
        t2.start();
        t3.start();
    }
}