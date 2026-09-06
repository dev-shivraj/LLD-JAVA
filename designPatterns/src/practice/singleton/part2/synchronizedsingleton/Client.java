package practice.singleton.part2.synchronizedsingleton;

public class Client {
    public static void main(String[] args) {
        System.out.println("Before getInstance()");
        SynchronizedSingleton singleton = SynchronizedSingleton.getInstance();
        System.out.println("After getInstance()");
    }
}