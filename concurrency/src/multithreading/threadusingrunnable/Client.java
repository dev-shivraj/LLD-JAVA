package multithreading.threadusingrunnable;

public class Client {
    static void main() {
        NumberPrinter numberPrinter = new NumberPrinter();
        Thread thread = new Thread(numberPrinter);
        thread.start();

        System.out.println("Main thread is running concurrently with the number printing thread.");
    }
}
