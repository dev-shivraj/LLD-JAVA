package synchronization.synchronizedmethod;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Value value;

    public Adder(Value value) {
        this.value = value;
    }

    public void add() throws InterruptedException {
        for (int i = 1; i <= 10000; i++) {
            this.value.decrement();
        }
    }

    @Override
    public Void call() throws Exception {
        add();
        return null;
    }
}
