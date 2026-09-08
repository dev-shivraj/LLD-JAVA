package practice.factory.part1.notification.service;

import practice.factory.part1.notification.factory.NotificationFactory;
import practice.factory.part1.notification.notification.Notification;

public class NotificationService {
    public void sendNotification(String type, String message) {
        Notification notification = NotificationFactory.createNotification(type);

        notification.send(message);
    }
}