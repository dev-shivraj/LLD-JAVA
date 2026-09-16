package practice.strategy.part1.example2.service;

import practice.strategy.part1.example2.strategy.NotificationStrategy;

public class NotificationService {

    private final NotificationStrategy notificationStrategy;

    public NotificationService(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public void sendNotification(String message) {
        notificationStrategy.send(message);
    }
}