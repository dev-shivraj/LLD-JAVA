package practice.factory.part1.practice2.factory;

import practice.factory.part1.practice2.notificationclient.EmailClient;
import practice.factory.part1.practice2.notificationclient.SmsClient;
import practice.factory.part1.practice2.sender.EmailNotification;
import practice.factory.part1.practice2.sender.NotificationSender;
import practice.factory.part1.practice2.sender.SmsNotification;

public class NotificationFactory {

    public static NotificationSender create(String type) {

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Notification type cannot be null or blank");
        }

        return switch (type.toLowerCase()) {
            case "email" -> {
                EmailClient client = new EmailClient();
                yield new EmailNotification(client);
            }
            case "sms" -> {
                SmsClient client = new SmsClient();
                yield new SmsNotification(client);
            }
            default -> throw new IllegalArgumentException("Unknown notification type: " + type);
        };
    }
}