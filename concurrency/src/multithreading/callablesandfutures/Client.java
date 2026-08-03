package multithreading.callablesandfutures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    static void main() throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        NumberMultiplier numberMultiplier1 = new NumberMultiplier(5);
        NumberMultiplier numberMultiplier2 = new NumberMultiplier(10);

        // execute => when we don't need to return the result from the thread
        // submit => when we need to return the result from the thread
        Future<Integer> future1 = ex.submit(numberMultiplier1);
        Future<Integer> future2 = ex.submit(numberMultiplier2);

        System.out.println("Hello from main thread");

        int res1 = future1.get(); // This will block until the result is available
        int res2 = future2.get(); // This will block until the result is available

        // if thread1 takes 3 sec to complete and thread2 takes 3 sec to complete
        // then the total time taken will be 3 sec because both threads are running in parallel
        System.out.println("Result from thread 1: " + res1);
        System.out.println("Result from thread 2: " + res2);

        System.out.println("Hello from main thread after getting the result");

    }
}
