package practice.concurrency_fundamentals_01.part2;

public class LifecycleClient {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Task is executing");
        });

        System.out.println("1. " + thread.getState());
        thread.start();

        System.out.println("2. " + thread.getState());
        thread.join();

        System.out.println("3. " + thread.getState());
    }
}
