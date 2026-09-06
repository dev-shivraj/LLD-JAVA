package practice.singleton.part4.practice2;

import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        SerializableSingleton singleton1 = SerializableSingleton.getInstance();

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("singleton.ser"))) {
            output.writeObject(singleton1);
        }

        SerializableSingleton singleton2;
        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("singleton.ser"))) {
            singleton2 = (SerializableSingleton) input.readObject();
        }

        System.out.println(singleton1 == singleton2);
    }
}