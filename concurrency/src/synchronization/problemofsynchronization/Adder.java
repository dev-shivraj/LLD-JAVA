package synchronization.problemofsynchronization;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Value value;

    public Adder(Value value) {
        this.value = value;
    }

    public void add() {
        for (int i = 1; i <= 1000; i++) {
            this.value.setX(this.value.getX() + 1);
        }
    }

    @Override
    public Void call() throws Exception {
        add();
        return null;
    }
}
