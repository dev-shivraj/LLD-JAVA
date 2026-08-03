package multithreading.threadusingrunnable;

public class Client2 {
    public static void main(String[] args) {

        // Create and start 100 threads, each printing a single number from 1 to 100
        for(int i = 1; i <= 100; i++) {
            SingleNumberPrinter printer = new SingleNumberPrinter(i);
            Thread thread = new Thread(printer);
            thread.start();
        }

        System.out.println("All threads have been created and started. It will be scheduled by the thread scheduler to run concurrently.");
    }
}
