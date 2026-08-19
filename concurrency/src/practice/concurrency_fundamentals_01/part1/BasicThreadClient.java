package practice.concurrency_fundamentals_01.part1;

public class BasicThreadClient {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Worker is running");
            }
        };


        Thread thread = new Thread(runnable);

        System.out.println("Before Thread");
        thread.start();
        System.out.println("After Thread");
    }
}
