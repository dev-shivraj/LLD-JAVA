package practice.singleton.part3.synchronizedsingleton;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private final int id;

    private ThreadSafeSingleton() {
        id = System.identityHashCode(this);
        System.out.println("Created by " + Thread.currentThread().getName());
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }

        return instance;
    }

    public int getId() {
        return id;
    }
}