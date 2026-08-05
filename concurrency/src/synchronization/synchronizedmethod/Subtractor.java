package synchronization.synchronizedmethod;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {
    private Value value;

    public Subtractor(Value value) {
        this.value = value;
    }

    public void subtract() throws InterruptedException {
        for (int i = 1; i <= 10000; i++) {
            this.value.increment();
        }
    }

    @Override
    public Void call() throws Exception {
        subtract();
        return null;
    }
}
