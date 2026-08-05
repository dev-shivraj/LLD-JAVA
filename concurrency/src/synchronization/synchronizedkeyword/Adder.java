package synchronization.synchronizedkeyword;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Value value;

    public Adder(Value value) {
        this.value = value;
    }

    public void add() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            synchronized (this.value) {
                System.out.println("=======================================================================================");
                System.out.println("Entered synchronized block in Adder, current value: " + this.value.getX());
                this.value.setX(this.value.getX() + 1);

                // Simulate some processing time to increase the chance of context switching and thread contention
                Thread.sleep(1);
                System.out.println("Thread " + Thread.currentThread().getName() + " added 1, new value: " + this.value.getX());
                System.out.println("Exiting synchronized block in Adder, current value: " + this.value.getX());
                System.out.println("=======================================================================================");
            }
        }
    }

    @Override
    public Void call() throws Exception {
        add();
        return null;
    }
}
