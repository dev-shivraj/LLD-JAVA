package practice.singleton.part3.unsafe.slowsingleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RaceClient {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 1000; i++) {
            executor.submit(SlowSingleton::getInstance);
        }

        executor.shutdown();
    }
}