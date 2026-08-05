package synchronization.synchronizedkeyword;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {
    private Value value;

    public Subtractor(Value value) {
        this.value = value;
    }

    public void subtract() {
        for (int i = 1; i <= 100000; i++) {
            synchronized (this.value) {
                this.value.setX(this.value.getX() - 1);
                System.out.println("Thread " + Thread.currentThread().getName() + " subtracted 1, new value: " + this.value.getX());
            }
        }
    }

    @Override
    public Void call() throws Exception {
        subtract();
        return null;
    }
}
