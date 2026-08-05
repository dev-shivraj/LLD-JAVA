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

                // ============================================================================================================================================================
                // simulate if some other task needs to done and same thread can enter the critical section again, then it can do that because the lock is reentrant
                someOtherTask();
                // ============================================================================================================================================================

                // Simulate some processing time to increase the chance of context switching and thread contention
                Thread.sleep(1);
                System.out.println("Thread " + Thread.currentThread().getName() + " added 1, new value: " + this.value.getX());
                System.out.println("Exiting synchronized block in Adder, current value: " + this.value.getX());
                System.out.println("=======================================================================================");
            }
        }
    }

    private void someOtherTask() throws InterruptedException {
        synchronized (this.value) {
            System.out.println("========== some other task =========");
            // simulate some other task that needs to be done while holding the lock
            System.out.println("Thread " + Thread.currentThread().getName() + " is doing some other task while holding the lock");
            Thread.sleep(1);
            System.out.println("===== some other task finished =====");
        }
    }

    @Override
    public Void call() throws Exception {
        add();
        return null;
    }
}
