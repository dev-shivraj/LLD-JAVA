package multithreading;

public class ClientWithoutMultithreading {
    static void main() throws InterruptedException {
        // get the number of cores in your system
        int numCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of cores in your system: " + numCores);

        // normal program to print numbers from 1 to 100 without multithreading
        for(int i = 1; i <= 100; i++) {
            // sleep for 1 second to simulate a long running task
            Thread.sleep(1000);
            System.out.println(i);
        }
    }
}
