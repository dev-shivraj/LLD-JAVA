package practice.singleton.part4.attack.reflection;

public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        System.out.println("Constructor called");
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}