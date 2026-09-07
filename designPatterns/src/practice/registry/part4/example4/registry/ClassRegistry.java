package practice.registry.part4.example4.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClassRegistry {

    private final Map<Class<?>, Object> objects = new ConcurrentHashMap<>();

    public <T> void register(Class<T> type, T object) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        if (object == null) {
            throw new IllegalArgumentException("Object cannot be null");
        }

        objects.put(type, object);
    }

    public <T> T get(Class<T> type) {

        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        Object object = objects.get(type);

        if (object == null) {
            throw new IllegalArgumentException("No object registered for type: " + type.getName());
        }

        return type.cast(object);
    }
}