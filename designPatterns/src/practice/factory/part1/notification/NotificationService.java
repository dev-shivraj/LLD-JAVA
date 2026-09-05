package practice.factory.part1.notification;

public class NotificationService {
    public void sendNotification(String type, String message) {
        Notification notification = NotificationFactory.createNotification(type);

        notification.send(message);
    }
}