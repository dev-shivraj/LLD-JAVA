package practice.singleton.part3.example.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private static volatile Counter instance;

    private final AtomicInteger count = new AtomicInteger();

    private Counter() {
    }

    public static Counter getInstance() {
        if (instance == null) {
            synchronized (Counter.class) {
                if (instance == null) {
                    instance = new Counter();
                }
            }
        }

        return instance;
    }

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}