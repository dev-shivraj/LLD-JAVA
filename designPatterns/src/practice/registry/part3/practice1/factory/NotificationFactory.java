package practice.registry.part3.practice1.factory;

import practice.registry.part3.practice1.registry.NotificationCreatorRegistry;
import practice.registry.part3.practice1.sender.NotificationSender;

import java.util.function.Supplier;

public class NotificationFactory {

    private final NotificationCreatorRegistry registry;

    public NotificationFactory(NotificationCreatorRegistry registry) {
        this.registry = registry;
    }

    public NotificationSender create(String type) {
        Supplier<NotificationSender> creator = registry.get(type);

        return creator.get();
    }
}