package synchronization.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {
    private Value value;
    private Lock lock;

    public Subtractor(Value value, Lock lock) {
        this.value = value;
        this.lock = lock;
    }

    public void subtract() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            // try to acquire the lock before adding
            // we can only try because if the lock is already held by another thread, we will wait until it is released
            lock.lock();

            System.out.println("====================================================================================================================");
            System.out.println("LOCKED: Thread " + Thread.currentThread().getName() + " acquired the lock at iteration " + i);

            this.value.setX(this.value.getX() - 1);
            System.out.println("Thread " + Thread.currentThread().getName() + " subtracted 1, new value: " + this.value.getX());

            Thread.sleep(1); // simulate some work being done while holding the lock
            System.out.println("ABOUT TO UNLOCK: Thread " + Thread.currentThread().getName() + " releasing the lock at iteration " + i);
            System.out.println("====================================================================================================================");

            // release the lock after subtracting
            lock.unlock();
        }
    }

    @Override
    public Void call() throws Exception {
        subtract();
        return null;
    }
}
