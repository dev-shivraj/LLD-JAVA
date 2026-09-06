package practice.singleton.part2.enumsingleton;

public class Client {

    public static void main(String[] args) {
        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        EnumSingleton singleton2 = EnumSingleton.INSTANCE;

        singleton1.doSomething();
        System.out.println(singleton1 == singleton2);
    }
}