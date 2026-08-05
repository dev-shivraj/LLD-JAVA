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
        for (int i = 1; i <= 1000; i++) {
            // try to acquire the lock before adding
            // we can only try because if the lock is already held by another thread, we will wait until it is released
            lock.lock();

            System.out.println("====================================================================================================================");
            System.out.println("LOCKED: Thread " + Thread.currentThread().getName() + " acquired the lock at iteration " + i);

            this.value.setX(this.value.getX() - 1);
            System.out.println("Thread " + Thread.currentThread().getName() + " subtracted 1, new value: " + this.value.getX());

            // ============================================================================================================================================================
            // simulate if some other task needs to done and same thread can enter in the critical section again, then it can do that because the lock is reentrant

            // print the hold count and queue length of the lock
            System.out.println("Lock hold count: " + ((java.util.concurrent.locks.ReentrantLock) lock).getHoldCount());
            System.out.println("Lock queue length: " + ((java.util.concurrent.locks.ReentrantLock) lock).getQueueLength());
            someOtherTask();

            // ============================================================================================================================================================


            Thread.sleep(1); // simulate some work being done while holding the lock
            System.out.println("ABOUT TO UNLOCK: Thread " + Thread.currentThread().getName() + " releasing the lock at iteration " + i);
            System.out.println("====================================================================================================================");

            // release the lock after subtracting
            lock.unlock();
        }
    }

    private void someOtherTask() throws InterruptedException {
        lock.lock();
        System.out.println("========== some other task =========");
        // print the hold count and queue length of the lock
        System.out.println("Lock hold count: " + ((java.util.concurrent.locks.ReentrantLock) lock).getHoldCount());
        System.out.println("Lock queue length: " + ((java.util.concurrent.locks.ReentrantLock) lock).getQueueLength());

        // simulate some other task that needs to be done while holding the lock
        System.out.println("Thread " + Thread.currentThread().getName() + " is doing some other task while holding the lock");
        Thread.sleep(1);
        System.out.println("===== some other task finished =====");

        lock.unlock();
    }


    @Override
    public Void call() throws Exception {
        subtract();
        return null;
    }
}
