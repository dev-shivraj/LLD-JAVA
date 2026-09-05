package practice.factory.part3.registryfactory.notification.service;

import practice.factory.part3.registryfactory.notification.component.Notification;
import practice.factory.part3.registryfactory.notification.enums.NotificationType;
import practice.factory.part3.registryfactory.notification.factory.NotificationFactory;

public class NotificationService {
    NotificationFactory notificationFactory;

    public NotificationService(NotificationFactory notificationFactory) {
        this.notificationFactory = notificationFactory;
    }

    public void sendNotification(NotificationType notificationType, String message) {
        Notification notification = notificationFactory.create(notificationType);
        notification.send(message);
    }
}
