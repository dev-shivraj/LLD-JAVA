package practice.factory.part2.example1.factory;

import practice.factory.part2.example1.notification.NotificationSender;
import practice.factory.part2.example1.notification.EmailNotification;
import practice.factory.part2.example1.notification.PushNotification;
import practice.factory.part2.example1.notification.SmsNotification;

public class NotificationFactory {
    public static NotificationSender create(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Notification type cannot be null or blank");
        }

        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SmsNotification();
            case "push" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown notification type: " + type);
        };
    }
}