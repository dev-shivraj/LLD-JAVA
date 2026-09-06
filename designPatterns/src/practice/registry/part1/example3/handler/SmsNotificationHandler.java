package practice.registry.part1.example3.handler;

public class SmsNotificationHandler implements NotificationHandler {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS Notification: " + message);
    }
}
