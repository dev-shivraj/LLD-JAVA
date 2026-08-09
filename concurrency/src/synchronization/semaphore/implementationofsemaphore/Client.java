package synchronization.semaphore.implementationofsemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {

    public static void main(String[] args) {
        Store store = new Store(10);
        Semaphore producerSemaphore = new Semaphore(10);
        Semaphore consumerSemaphore = new Semaphore(0);

        // 10 producers
        // 15 consumers

        ExecutorService ex = Executors.newCachedThreadPool();

        for(int i = 1; i <= 8; i++) {
            Producer producer = new Producer(store, producerSemaphore, consumerSemaphore);
            ex.execute(producer);
        }

        for(int i = 1; i <= 20; i++) {
            Consumer consumer = new Consumer(store, producerSemaphore, consumerSemaphore);
            ex.execute(consumer);
        }

        ex.shutdown();
    }
}
