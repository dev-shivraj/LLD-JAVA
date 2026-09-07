package practice.registry.part3.practice1.service;

import practice.registry.part3.practice1.factory.NotificationFactory;
import practice.registry.part3.practice1.sender.NotificationSender;

public class NotificationService {

    private final NotificationFactory factory;

    public NotificationService(NotificationFactory factory) {
        this.factory = factory;
    }

    public void send(String type, String message) {
        NotificationSender sender = factory.create(type);

        sender.send(message);
    }
}