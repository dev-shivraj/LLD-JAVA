package multithreading.usingthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
    In this example, we will create a fixed thread pool with just 2 threads and submit 1 million tasks to it.
    Each task will print a number from 1 to 1 million.
    We will see that the program will complete in around 2-3 seconds, which is much faster than the normal program with each task running in a separate thread, which takes around 30 seconds to complete the task.
 */
public class ClientFixThreadPool {
    static void main() {
        // without fixed thread pool, we will create a new thread for each task, which is not efficient
        // normal program to print numbers from 1 to 1000000 with each task running in a separate thread
        // it takes around 30 seconds to complete the task
        /*
        for(int i = 1; i <= 1_000_000; i++) {
            Thread thread = new Thread(new SingleNumberPrinter(i));
            thread.start();
        }
         */


        // with fixed thread pool, we will create a fixed number of threads and reuse them for each task, which is more efficient
        // program to print numbers from 1 to 1000000 with multithreading
        // it takes around 2-3 seconds to complete the task if we use a fixed thread pool with 2 threads
        // create a fixed thread pool with just 2 threads
        int numCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of cores in your system: " + numCores);
        ExecutorService executorService = Executors.newFixedThreadPool(2); // instead of 2, we can use numCores to create a thread pool with the number of threads equal to the number of cores in the system
        for(int i = 1; i <= 1_000_000; i++) {
            if(i == 500_000) {
                System.out.println("DEBUG : Halfway done!");
            }
            executorService.execute(new SingleNumberPrinter(i));
        }
    }
}
