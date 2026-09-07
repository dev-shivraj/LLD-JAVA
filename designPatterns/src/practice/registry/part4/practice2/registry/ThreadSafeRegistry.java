package practice.registry.part4.practice2.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class ThreadSafeRegistry<T> {

    private final Map<String, Supplier<T>> creators = new ConcurrentHashMap<>();

    public void register(String type, Supplier<T> creator) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }

        if (creator == null) {
            throw new IllegalArgumentException("Creator cannot be null");
        }

        Supplier<T> existing = creators.putIfAbsent(type, creator);

        if (existing != null) {
            throw new IllegalArgumentException("Creator already registered for type: " + type);
        }
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