package practice.singleton.part1.counter;

public class Counter {
    private static Counter instance = new Counter();
    private int count;

    private Counter() {
    }

    public static Counter getInstance() {
        return instance;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}