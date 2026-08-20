package practice.concurrency_fundamentals_01.part3;

public class YieldClient {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                System.out.println("A-" + i);
                Thread.yield();
            }

        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                System.out.println("B-" + i);
                Thread.yield();
            }
        });

        t1.start();
        t2.start();
    }
}
