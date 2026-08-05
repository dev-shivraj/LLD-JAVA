package synchronization.synchronizedkeyword;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Value value;

    public Adder(Value value) {
        this.value = value;
    }

    public void add() {
        for (int i = 1; i <= 100000; i++) {
            synchronized (this.value) {
                this.value.setX(this.value.getX() + 1);
                System.out.println("Thread " + Thread.currentThread().getName() + " added 1, new value: " + this.value.getX());
            }
        }
    }

    @Override
    public Void call() throws Exception {
        add();
        return null;
    }
}
