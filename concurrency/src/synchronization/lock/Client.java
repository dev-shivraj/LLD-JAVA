package synchronization.lock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * we can lock the critical section of the code using a Lock object to ensure that only one thread can access it at a time
 * This prevents race conditions and ensures data consistency.
 * If we forget to release the lock, the other thread will wait forever and the program will hang.
 */
public class Client {
    static void main() throws ExecutionException, InterruptedException {
        Value value = new Value(0);

        Lock lock = new ReentrantLock();
//        Lock lock2 = new ReentrantLock();

        Adder adder = new Adder(value, lock);

        // if we use a different lock for the subtractor, then the two threads can access the critical section at the same time and we will have a race condition
//        Subtractor subtractor = new Subtractor(value, lock2);
        Subtractor subtractor = new Subtractor(value, lock);

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
