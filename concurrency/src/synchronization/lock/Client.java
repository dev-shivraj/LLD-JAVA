package synchronization.lock;

import synchronization.problemofsynchronization.Adder;
import synchronization.problemofsynchronization.Subtractor;
import synchronization.problemofsynchronization.Value;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*

 */
public class Client {
    static void main() throws ExecutionException, InterruptedException {
        Value value = new Value(0);

        synchronization.problemofsynchronization.Adder adder = new Adder(value);
        Subtractor subtractor = new Subtractor(value);

        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Void> future1 = ex.submit(adder);
        Future<Void> future2 = ex.submit(subtractor);

        future1.get();
        future2.get();

        // Shutdown the executor service
        ex.shutdown();

        // final value should be 0, but due to the lack of synchronization, it may not be 0
        // it gives different results on different runs
        System.out.println("Final value: " + value.getX());
    }
}
