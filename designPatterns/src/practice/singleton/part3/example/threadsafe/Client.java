package practice.singleton.part3.example.threadsafe;

public class Client {

    public static void main(String[] args) {
        SynchronizedSingleton s1 = SynchronizedSingleton.getInstance();
        SynchronizedSingleton s2 = SynchronizedSingleton.getInstance();
        DoubleCheckedSingleton d1 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton d2 = DoubleCheckedSingleton.getInstance();

        System.out.println(s1 == s2);
        System.out.println(d1 == d2);
    }
}