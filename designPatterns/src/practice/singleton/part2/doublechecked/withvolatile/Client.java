package practice.singleton.part2.doublechecked.withvolatile;

public class Client {
    public static void main(String[] args) {
        System.out.println("Before getInstance()");
        DoubleCheckedSingleton singleton = DoubleCheckedSingleton.getInstance();
        System.out.println("After getInstance()");
    }
}