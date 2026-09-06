package practice.singleton.part4.practice1;

import java.lang.reflect.Constructor;

public class Client {
    public static void main(String[] args) throws Exception {
        Singleton singleton1 = Singleton.getInstance();
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();

        constructor.setAccessible(true);

        Singleton singleton2 = constructor.newInstance();
        System.out.println(singleton1 == singleton2);
    }
}