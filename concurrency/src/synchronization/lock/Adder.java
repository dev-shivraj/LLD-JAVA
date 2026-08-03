package synchronization.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private Value value;
    private Lock lock;

    public Adder(Value value, Lock lock) {
        this.value = value;
        this.lock = lock;
    }

    public void add() {
        for (int i = 1; i <= 1000; i++) {
            // try to acquire the lock before adding
            // we can only try because if the lock is already held by another thread, we will wait until it is released
            lock.lock();

            this.value.setX(this.value.getX() + 1);

            // release the lock after adding
            lock.unlock();
        }
    }

    @Override
    public Void call() throws Exception {
        add();
        return null;
    }
}
