package practice.registry.part4.practice1.registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Registry<T> {

    private final Map<String, Supplier<T>> creators = new HashMap<>();

    public void register(String type, Supplier<T> creator) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }

        if (creator == null) {
            throw new IllegalArgumentException("Creator cannot be null");
        }

        if (creators.containsKey(type)) {
            throw new IllegalArgumentException("Creator already registered for type: " + type);
        }

        creators.put(type, creator);
    }

    public Supplier<T> get(String type) {

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }

        Supplier<T> creator = creators.get(type);

        if (creator == null) {
            throw new IllegalArgumentException("No creator registered for type: " + type);
        }

        return creator;
    }
}