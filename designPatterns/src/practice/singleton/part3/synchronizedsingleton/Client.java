package practice.singleton.part3.synchronizedsingleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + " -> " + singleton.getId());
            });
        }

        executor.shutdown();
    }
}