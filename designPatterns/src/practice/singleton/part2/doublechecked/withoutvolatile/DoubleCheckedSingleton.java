package practice.singleton.part2.doublechecked.withoutvolatile;

public class DoubleCheckedSingleton {
    private static DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {
        System.out.println("DoubleCheckedSingleton created");
    }

    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }

        return instance;
    }
}