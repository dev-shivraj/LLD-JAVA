package multithreading.add1tomillion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws Exception {
        int n = 1_000_000;

        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        List<Future<Long>> futures = new ArrayList<>();
        int chunkSize = n / numberOfThreads;
        int start = 1;

        for (int i = 0; i < numberOfThreads; i++) {
            int end;
            if (i == numberOfThreads - 1) {
                end = n;
            } else {
                end = start + chunkSize - 1;
            }

            futures.add(executor.submit(new SumTask(start, end)));
            start = end + 1;
        }

        long totalSum = 0;
        for (Future<Long> future : futures) {
            totalSum += future.get();
        }

        executor.shutdown();
        System.out.println("\nTotal Sum = " + totalSum);
    }
}
