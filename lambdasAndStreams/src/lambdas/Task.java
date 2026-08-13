package lambdas;

public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Task is running");
    }
}
