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
            // what will happen if we forget to release the consumerSemaphore here?
            // If we forget to release the consumerSemaphore, consumers may be blocked indefinitely, waiting for an item to become available.
            // situation of deadlock may occur where producers are producing items but consumers are not able to consume them because they are blocked waiting for a permit from the consumerSemaphore.


            // what will happen if we release the consumerSemaphore again here?
            // It will allow a consumer to acquire it and consume the item
            // but it may lead to an imbalance between production and consumption
            // This could result in Index -1 out of bounds for length 0 error when a consumer tries to consume an item that doesn't exist, or it could lead to a situation where producers are blocked because the store is full, even though there are consumers waiting to consume items.
            // Therefore, it's important to release the consumerSemaphore only once after producing an item to maintain the balance between production and consumption.
//             consumerSemaphore.release();
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
