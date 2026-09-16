package practice.strategy.part4.practice3.service;

import practice.strategy.part4.practice3.registry.NotificationRegistry;
import practice.strategy.part4.practice3.strategy.NotificationStrategy;

public class NotificationService {

    private final NotificationRegistry registry;

    public NotificationService(
            NotificationRegistry registry
    ) {
        this.registry = registry;
    }

    public void send(
            String type,
            String message
    ) {

        NotificationStrategy strategy =
                registry.get(type);

        strategy.send(message);
    }
}