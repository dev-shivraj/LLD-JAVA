package synchronization.semaphore.implementationofsemaphore;

public class Producer implements Runnable {
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    public void produce() {
        while (true) {
            store.addItem(new Object());
        }
    }

    @Override
    public void run() {
        produce();
    }
}
