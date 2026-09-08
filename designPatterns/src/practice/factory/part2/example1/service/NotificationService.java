package practice.factory.part2.example1.service;

import practice.factory.part2.example1.notification.NotificationSender;
import practice.factory.part2.example1.factory.NotificationFactory;

public class NotificationService {
    public void send(String type, String message) {
        NotificationSender sender = NotificationFactory.create(type);
        sender.send(message);
    }
}