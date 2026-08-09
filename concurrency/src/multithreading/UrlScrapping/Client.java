package multithreading.UrlScrapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    static void main() throws ExecutionException, InterruptedException {
        ArrayList<String> urls = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            urls.add("http://example.com/page" + i);
        }

        ExecutorService fixedPool = Executors.newFixedThreadPool(10);
        long fixedTime = executeTask(urls, fixedPool);
        System.out.println("Time taken with fixed thread pool: " + fixedTime + " ms");


        ExecutorService cachedPool = Executors.newCachedThreadPool();
        long cachedTime = executeTask(urls, cachedPool);
        System.out.println("Time taken with cached thread pool: " + cachedTime + " ms");

    }

    private static long executeTask(List<String> urls, ExecutorService executor) throws ExecutionException, InterruptedException {
        List<Future<Void>> futures = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (String url : urls) {
            UrlScrapper scrapper = new UrlScrapper(url);
            Future<Void> future = executor.submit(scrapper);
            futures.add(future);
        }

        executor.shutdown();
        for(Future<Void> future : futures) {
            // Wait for the task to complete
            future.get();
        }

        return System.currentTimeMillis() - startTime;
    }
}
