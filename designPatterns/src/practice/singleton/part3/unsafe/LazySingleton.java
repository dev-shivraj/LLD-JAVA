package practice.singleton.part3.unsafe;

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("Singleton created by " + Thread.currentThread().getName());
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }

        return instance;
    }
}