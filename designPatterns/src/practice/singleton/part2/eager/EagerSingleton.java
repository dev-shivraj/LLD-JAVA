package practice.singleton.part2.eager;

public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        System.out.println("EagerSingleton created");
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}