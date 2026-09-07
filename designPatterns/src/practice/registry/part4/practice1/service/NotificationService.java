package practice.registry.part4.practice1.service;

import practice.registry.part4.practice1.registry.Registry;
import practice.registry.part4.practice1.sender.NotificationSender;

import java.util.function.Supplier;

public class NotificationService {

    private final Registry<NotificationSender> registry;

    public NotificationService(Registry<NotificationSender> registry) {
        this.registry = registry;
    }

    public NotificationSender createSender(String type) {
        Supplier<NotificationSender> creator = registry.get(type);

        return creator.get();
    }

    public void send(String type, String message) {
        NotificationSender sender = createSender(type);

        sender.send(message);
    }
}