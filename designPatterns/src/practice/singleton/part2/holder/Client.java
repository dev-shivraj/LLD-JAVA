package practice.singleton.part2.holder;

public class Client {
    public static void main(String[] args) {
        System.out.println("Before getInstance()");
        HolderSingleton singleton = HolderSingleton.getInstance();
        System.out.println("After getInstance()");
    }
}