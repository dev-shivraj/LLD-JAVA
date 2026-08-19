package practice.concurrency_fundamentals_01.part1;

public class ThreadExecutionOrderClient {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("worker-A started");
            System.out.println("worker-A working1");
            System.out.println("worker-A working2");
            System.out.println("worker-A working3");
            System.out.println("worker-A finished");
        }, "A");

        Thread thread2 = new Thread(() -> {
            System.out.println("worker-B started");
            System.out.println("worker-B working1");
            System.out.println("worker-B working2");
            System.out.println("worker-B working3");
            System.out.println("worker-B finished");
        }, "B");

        Thread thread3 = new Thread(() -> {
            System.out.println("worker-C started");
            System.out.println("worker-C working1");
            System.out.println("worker-C working2");
            System.out.println("worker-C working3");
            System.out.println("worker-C finished");
        }, "C");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
