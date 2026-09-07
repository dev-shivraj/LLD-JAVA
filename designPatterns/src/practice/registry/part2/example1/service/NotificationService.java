package practice.registry.part2.example1.service;

import practice.registry.part2.example1.registry.NotificationRegistry;
import practice.registry.part2.example1.handler.NotificationHandler;

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