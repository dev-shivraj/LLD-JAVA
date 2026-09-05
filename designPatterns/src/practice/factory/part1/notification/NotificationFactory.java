package practice.factory.part1.notification;

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