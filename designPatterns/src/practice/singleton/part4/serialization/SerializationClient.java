package practice.singleton.part4.serialization;

import java.io.*;

public class SerializationClient {
    public static void main(String[] args) throws Exception {
        Singleton singleton1 = Singleton.getInstance();
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("singleton.ser"));

        output.writeObject(singleton1);
        output.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream("singleton.ser"));
        Singleton singleton2 = (Singleton) input.readObject();
        input.close();

        System.out.println(singleton1 == singleton2);
    }
}