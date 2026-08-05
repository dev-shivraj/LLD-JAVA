package synchronization.synchronizedmethod;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 *
 */
public class Client {
    static void main() throws ExecutionException, InterruptedException {
        Value value = new Value(0);


        Adder adder = new Adder(value);
        Subtractor subtractor = new Subtractor(value);

        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Void> future1 = ex.submit(adder);
        Future<Void> future2 = ex.submit(subtractor);

        future1.get();
        future2.get();

        // Shutdown the executor service
        ex.shutdown();

        System.out.println("Final value: " + value.getX());
    }
}
