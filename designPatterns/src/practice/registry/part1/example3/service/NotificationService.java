package practice.registry.part1.example3.service;

import practice.registry.part1.example3.handler.NotificationHandler;
import practice.registry.part1.example3.registry.NotificationRegistry;

public class NotificationService {
    private final NotificationRegistry registry;

    public NotificationService(NotificationRegistry registry) {
        this.registry = registry;
    }

    public void send(String type, String message) {
        NotificationHandler handler = registry.get(type);
        handler.send(message);
    }
}