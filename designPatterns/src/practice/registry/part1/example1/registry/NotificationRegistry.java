package practice.registry.part1.example1.registry;

import practice.registry.part1.example1.handler.NotificationHandler;

import java.util.HashMap;
import java.util.Map;

public class NotificationRegistry {
    private final Map<String, NotificationHandler> handlers = new HashMap<>();

    public void register(String type, NotificationHandler handler) {
        handlers.put(type, handler);
    }

    public NotificationHandler get(String key) {
        return handlers.get(key);
    }
}
