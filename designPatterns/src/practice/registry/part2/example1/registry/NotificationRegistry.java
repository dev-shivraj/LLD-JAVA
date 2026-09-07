package practice.registry.part2.example1.registry;

import practice.registry.part2.example1.handler.NotificationHandler;

import java.util.HashMap;
import java.util.Map;

public class NotificationRegistry {

    private final Map<String, NotificationHandler> handlers = new HashMap<>();

    public void register(String type, NotificationHandler handler) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }

        if (handler == null) {
            throw new IllegalArgumentException("Handler cannot be null");
        }

        if (handlers.containsKey(type)) {
            throw new IllegalArgumentException("Handler already registered for type: " + type);
        }

        handlers.put(type, handler);
    }

    public NotificationHandler get(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }

        NotificationHandler handler = handlers.get(type);

        if (handler == null) {
            throw new IllegalArgumentException("No handler registered for type: " + type);
        }

        return handler;
    }
}