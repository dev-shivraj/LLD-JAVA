package multithreading.callablesandfutures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    static void main() throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        NumberMultiplier numberMultiplier = new NumberMultiplier(5);

        // execute => when we don't need to return the result from the thread
        // submit => when we need to return the result from the thread
        Future<Integer> future = ex.submit(numberMultiplier);

        System.out.println("Hello from main thread");

        int res = future.get(); // This will block until the result is available
        System.out.println("Result from thread: " + res);

        System.out.println("Hello from main thread after getting the result");

    }
}
