package synchronization.semaphore.implementationofsemaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Store store;
    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;

    public Consumer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    public void consume() throws InterruptedException {
        while (true) {
            // will try to acquire a permit from the consumer semaphore, if no permits are available, it will block until one is released
            // kind of try to consumer--
            consumerSemaphore.acquire();

            store.removeItem();

            // after consuming an item, it releases a permit on the producer semaphore, signaling that there is now space available for production
            // it will definitely release a permit on the producer semaphore, allowing a producer to acquire it
            // kind of try to  producer++
            producerSemaphore.release();
        }
    }


    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
