package synchronization.problemofsynchronization;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {
    private Value value;

    public Subtractor(Value value) {
        this.value = value;
    }

    public void subtract() {
        for (int i = 1; i <= 1000; i++) {
            this.value.setX(this.value.getX() - 1);
        }
    }

    @Override
    public Void call() throws Exception {
        subtract();
        return null;
    }
}
