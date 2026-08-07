package synchronization.semaphore.producerconsumerproblem;

public class Consumer implements Runnable {
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    public void consume() {
        while (true) {
            store.removeItem();
        }
    }


    @Override
    public void run() {
        consume();
    }
}
