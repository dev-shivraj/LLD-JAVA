package synchronization.semaphore.implementationofsemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {
        Store store = new Store(10);

        // 10 producers
        // 15 consumers

        ExecutorService ex = Executors.newCachedThreadPool();

        for(int i = 1; i <= 10; i++) {
            Producer producer = new Producer(store);
            ex.execute(producer);
        }

        for(int i = 1; i <= 15; i++) {
            Consumer consumer = new Consumer(store);
            ex.execute(consumer);
        }

        ex.shutdown();
    }
}
