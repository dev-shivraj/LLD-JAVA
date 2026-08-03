package multithreading.add1tomillion;

import java.util.concurrent.Callable;

public class SumTask implements Callable<Long> {
    private final int start;
    private final int end;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    private long sum() {
        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    @Override
    public Long call() {
        return sum();
    }
}
