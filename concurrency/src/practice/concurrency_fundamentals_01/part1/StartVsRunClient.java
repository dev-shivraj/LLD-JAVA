package practice.concurrency_fundamentals_01.part1;

public class StartVsRunClient {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread name : " + Thread.currentThread().getName());
            System.out.println("Task is running");
        });

        // it won't create a separate thread
//        thread.run();


        // this will create a separate thread
        thread.start();
        System.out.println("Main finished");
    }
}
