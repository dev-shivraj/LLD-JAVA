package practice.registry.part4.example2.registry;

import java.util.HashMap;
import java.util.Map;

public class Registry<T> {

    private final Map<String, T> objects = new HashMap<>();

    public void register(String type, T object) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }

        if (object == null) {
            throw new IllegalArgumentException("Object cannot be null");
        }

        if (objects.containsKey(type)) {
            throw new IllegalArgumentException("Object already registered for type: " + type);
        }

        objects.put(type, object);
    }

    public T get(String type) {

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }

        T object = objects.get(type);

        if (object == null) {
            throw new IllegalArgumentException("No object registered for type: " + type);
        }

        return object;
    }
}