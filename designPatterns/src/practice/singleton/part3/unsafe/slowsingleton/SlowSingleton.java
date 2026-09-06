package practice.singleton.part3.unsafe.slowsingleton;

public class SlowSingleton {
    private static SlowSingleton instance;

    private SlowSingleton() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Created by " + Thread.currentThread().getName());
    }

    public static SlowSingleton getInstance() {
        if (instance == null) {
            instance = new SlowSingleton();
        }

        return instance;
    }
}