package practice.singleton.part2.synchronizedsingleton;

public class SynchronizedSingleton {
    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {
        System.out.println("SynchronizedSingleton Created");
    }

    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }

        return instance;
    }
}