package synchronization.problemofsynchronization;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
    * The Client class demonstrates the use of the Adder and Subtractor classes to modify a shared Value object concurrently.
    *
    * In this example, we add 1 to 1000 and subtract 1 from 1000, so the final value should be 0.
    * However, due to the lack of synchronization in the Value class, the final value may not be 0, as the operations may interfere with each other.
    * This demonstrates the problem of synchronization in concurrent programming, where multiple threads access and modify shared data without proper coordination.
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

        // final value should be 0, but due to the lack of synchronization, it may not be 0
        // it gives different results on different runs
        System.out.println("Final value: " + value.getX());
    }
}
