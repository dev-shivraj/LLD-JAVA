package practice.concurrency_fundamentals_01.part2;

public class TimedWaitingStateClient {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Task is executing");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread.start();
        Thread.sleep(100);

        System.out.println("Worker state: " + thread.getState());
        thread.join();
    }
}
