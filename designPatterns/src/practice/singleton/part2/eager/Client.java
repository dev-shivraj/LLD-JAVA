package practice.singleton.part2.eager;

public class Client {
    public static void main(String[] args) {
        System.out.println("Before getInstance()");
        EagerSingleton singleton = EagerSingleton.getInstance();
        System.out.println("After getInstance()");
    }
}