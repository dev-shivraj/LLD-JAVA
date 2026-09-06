package practice.singleton.part4.practice5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConfigClient {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            executor.submit(() -> {
                ApplicationConfig config = ApplicationConfig.getInstance();
                System.out.println(Thread.currentThread().getName() + " -> " + System.identityHashCode(config));
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.sleep(10);
        }

        ApplicationConfig config = ApplicationConfig.getInstance();
        config.printConfig();
    }
}