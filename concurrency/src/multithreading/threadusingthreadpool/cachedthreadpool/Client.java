package multithreading.threadusingthreadpool.cachedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
    In this example, we will create a cached thread pool and submit tasks to it.
    Each task will print a number from 1 to 100.
 */
public class Client {
    static void main() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 1; i <= 100; i++) {
            executorService.execute(new SingleNumberPrinter(i));
        }

        System.out.println("All tasks submitted.");
        executorService.shutdown();
    }
}
