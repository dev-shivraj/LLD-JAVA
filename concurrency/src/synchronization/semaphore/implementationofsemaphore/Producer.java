package synchronization.semaphore.implementationofsemaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Store store;
    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;

    public Producer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    public void produce() throws InterruptedException {
        while (true) {
            // will try to acquire a permit from the producer semaphore, if no permits are available, it will block until one is released
            // kind of try to producer--
            producerSemaphore.acquire();

            store.addItem(new Object());

            // after producing an item, it releases a permit on the consumer semaphore, signaling that there is now an item available for consumption
            // it will definitely release a permit on the consumer semaphore, allowing a consumer to acquire it and consume the item
            // kind of try to consumer++
            consumerSemaphore.release();
        }
    }

    @Override
    public void run() {
        try {
            produce();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
