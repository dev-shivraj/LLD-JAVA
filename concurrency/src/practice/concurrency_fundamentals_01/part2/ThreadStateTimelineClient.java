package practice.concurrency_fundamentals_01.part2;

public class ThreadStateTimelineClient {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Task is executing");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // NEW
        System.out.println("1. Worker state: " + thread.getState());

        thread.start();

        // RUNNABLE
        System.out.println("2. Worker state: " + thread.getState());


        Thread.sleep(100);

        // TIMED_WAITING
        System.out.println("3. Worker state: " + thread.getState());

        thread.join();

        // TERMINATED
        System.out.println("4. Worker state: " + thread.getState());
    }
}
