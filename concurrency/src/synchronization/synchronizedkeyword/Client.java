package synchronization.synchronizedkeyword;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * synchronized : syntactic sugar of locks, it is a keyword in Java that is used to control access to a shared resource by multiple threads.
 * When a method or block of code is marked as synchronized, only one thread can execute it at a time for a given object instance.
 * This ensures that the shared resource is accessed in a thread-safe manner, preventing race conditions and data inconsistencies.
 * The synchronized keyword can be applied to methods or blocks of code, and it can be used with instance methods (synchronized on the instance) or static methods (synchronized on the class).
 * However, excessive use of synchronized can lead to performance issues due to thread contention, so it should be used judiciously.
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
