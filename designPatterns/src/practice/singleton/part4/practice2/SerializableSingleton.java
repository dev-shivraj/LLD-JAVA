package practice.singleton.part4.practice2;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {
    private static final SerializableSingleton INSTANCE = new SerializableSingleton();

    private SerializableSingleton() {
    }

    public static SerializableSingleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}