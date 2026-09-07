package practice.registry.part3.practice1.registry;

import practice.registry.part3.practice1.sender.NotificationSender;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NotificationCreatorRegistry {

    private final Map<String, Supplier<NotificationSender>> creators = new HashMap<>();

    public void register(String type, Supplier<NotificationSender> creator) {
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

    public Supplier<NotificationSender> get(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }

        Supplier<NotificationSender> creator = creators.get(type);

        if (creator == null) {
            throw new IllegalArgumentException("No creator registered for type: " + type);
        }

        return creator;
    }
}