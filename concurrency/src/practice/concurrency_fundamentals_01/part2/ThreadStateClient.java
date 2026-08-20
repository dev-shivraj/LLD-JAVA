package practice.concurrency_fundamentals_01.part2;

public class ThreadStateClient {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Task is running");
        });

        System.out.println("Before start, thread state : " + thread.getState());

        thread.start();

        System.out.println("After start, thread state : " + thread.getState());
        System.out.println("After start, thread state : " + thread.getState());
        System.out.println("After start, thread state : " + thread.getState());
    }
}
