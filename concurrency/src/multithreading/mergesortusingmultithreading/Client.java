package multithreading.mergesortusingmultithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws Exception {
        // Create a list of integers to sort
        List<Integer> list = Arrays.asList(38, 27, 43, 3, 9, 82, 10);

//        ExecutorService ex = Executors.newFixedThreadPool(list.size());
        ExecutorService ex = Executors.newCachedThreadPool();
        Sorter sorter = new Sorter(list, ex);

        Future<List<Integer>> future = ex.submit(sorter);
        List<Integer> result = future.get();
        System.out.println("Sorted list: " + result);

//        ex.shutdown();
    }
}
