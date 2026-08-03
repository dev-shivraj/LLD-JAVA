package multithreading.callablesandfutures;

import java.util.concurrent.Callable;

/*
    This class implements the Callable interface to multiply a given number by 2.
    We use Callable instead of Runnable because we want to return a result (the multiplied number)
        Callable => when we need to return the result from the thread
        Runnable => when we don't need to return the result from the thread
 */
public class NumberMultiplier implements Callable<Integer> {
    private final int number;

    public NumberMultiplier(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        // Simulate some processing time
        Thread.sleep(3000);
        return number * 2;
    }
}
