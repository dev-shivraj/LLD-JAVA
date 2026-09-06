package practice.singleton.part2.lazy;

public class Client {
    public static void main(String[] args) {
        System.out.println("Before getInstance()");
        LazySingleton singleton = LazySingleton.getInstance();
        System.out.println("After getInstance()");
    }
}