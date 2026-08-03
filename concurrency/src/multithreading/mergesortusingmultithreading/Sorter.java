package multithreading.mergesortusingmultithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    private List<Integer> list;
    private ExecutorService executorService;

    public Sorter(List<Integer> list, ExecutorService executorService) {
        this.list = list;
        this.executorService = executorService;
    }

    private List<Integer> mergeSort(List<Integer> list, ExecutorService executorService) throws ExecutionException, InterruptedException {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<Integer> leftHalf = list.subList(0, mid);
        List<Integer> rightHalf = list.subList(mid, list.size());

        Sorter leftSorter = new Sorter(leftHalf, executorService);
        Sorter rightSorter = new Sorter(rightHalf, executorService);

        Future<List<Integer>> leftFuture = executorService.submit(leftSorter);
        Future<List<Integer>> rightFuture = executorService.submit(rightSorter);

        List<Integer> sortedLeft = leftFuture.get();
        List<Integer> sortedRight = rightFuture.get();

        List<Integer> mergedList = merge(sortedLeft, sortedRight);
        return mergedList;
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                mergedList.add(left.get(i++));
            } else {
                mergedList.add(right.get(j++));
            }
        }

        while (i < left.size()) {
            mergedList.add(left.get(i++));
        }

        while (j < right.size()) {
            mergedList.add(right.get(j++));
        }

        return mergedList;
    }

    @Override
    public List<Integer> call() throws Exception {
        return mergeSort(list, executorService);
    }
}
