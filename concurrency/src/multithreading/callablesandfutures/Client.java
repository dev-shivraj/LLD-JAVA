package multithreading.callablesandfutures;

import java.util.concurrent.*;

public class Client {
    static void main() throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        NumberMultiplier numberMultiplier1 = new NumberMultiplier(5);
        NumberMultiplier numberMultiplier2 = new NumberMultiplier(10);

        // execute => when we don't need to return the result from the thread
        // submit => when we need to return the result from the thread
        Future<Integer> future1 = ex.submit(numberMultiplier1);
        Future<Integer> future2 = ex.submit(numberMultiplier2);

        System.out.println("Hello from main thread");

        // ***************************************************************************************************************

        // ==============================================================
        // awaitTermination() is a method of Java’s ExecutorService
        // that waits for all submitted tasks to finish execution
        // after the executor has been shut down.
        // Important: It works only after shutdown()

        /*
            Create Executor
                    ↓
            Submit Tasks
                    ↓
            shutdown()
                    ↓
            awaitTermination()
                    ↓
            All tasks finish OR timeout occurs
                    ↓
            Program continues
         */

        // ==============================================================

        // No more new tasks
        // Stop accepting new tasks.
        // Already submitted tasks will continue to execute.
        /*
            shutdown() does NOT kill running tasks.
            It simply tells the ExecutorService:
            "Don't accept any new tasks, but finish the ones already submitted."
        */

        ex.shutdown();


        // wait for all the tasks to complete or timeout after 10 seconds
//        boolean completed = ex.awaitTermination(10, TimeUnit.SECONDS);
        boolean completed = ex.awaitTermination(1, TimeUnit.SECONDS);


        /*
            below line will be executed after :
            either all the tasks are finished
            or the given time completes then the program will continue from below line


            Execution resumes here when:
                1. All submitted tasks finish, OR
                2. The timeout expires (whichever happens first)
         */

        System.out.println("Executor finished: " + completed);
        System.out.println("All submitted tasks have completed.");
        System.out.println("Now we can get the result from the future object immediately");



        /*
        If all tasks have already completed,
                Future.get() returns immediately without blocking.
            otherwise :
                it will block the main thread until the result is available
                tasks continue running in the background
                because awaitTermination() does not stop them—it only waits.

        Note:
            - If the tasks are not completed within the given time, awaitTermination() will return false.
            - If the tasks are completed within the given time, awaitTermination() will return true.

            - If the tasks are not completed within the given time, we can still get the result from the future object,
                    but it will block the main thread until the result is available.

         */

        // ***************************************************************************************************************


        int res1 = future1.get(); // This will block until the result is available
        int res2 = future2.get(); // This will block until the result is available

        // if thread1 takes 3 sec to complete and thread2 takes 3 sec to complete
        // then the total time taken will be 3 sec because both threads are running in parallel
        System.out.println("Result from thread 1: " + res1);
        System.out.println("Result from thread 2: " + res2);

        System.out.println("Hello from main thread after getting the result");

    }
}
