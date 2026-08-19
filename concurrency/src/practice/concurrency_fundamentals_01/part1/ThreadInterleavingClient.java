package practice.concurrency_fundamentals_01.part1;

public class ThreadInterleavingClient {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("A" + i);
            }
        }, "A");

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("B" + i);
            }

        }, "B");

        t1.start();
        t2.start();
    }
}
