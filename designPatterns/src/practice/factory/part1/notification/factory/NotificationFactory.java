package practice.factory.part1.notification.factory;

import practice.factory.part1.notification.notification.EmailNotification;
import practice.factory.part1.notification.notification.Notification;
import practice.factory.part1.notification.notification.PushNotification;
import practice.factory.part1.notification.notification.SmsNotification;

public class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type.equals("EMAIL")) {
            return new EmailNotification();
        }

        if (type.equals("SMS")) {
            return new SmsNotification();
        }

        if (type.equals("PUSH")) {
            return new PushNotification();
        }

        throw new IllegalArgumentException("Unsupported notification type: " + type);
    }
}