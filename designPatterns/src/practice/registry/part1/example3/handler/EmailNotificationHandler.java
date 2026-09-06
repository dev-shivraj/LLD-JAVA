package practice.registry.part1.example3.handler;

public class EmailNotificationHandler implements NotificationHandler {
    @Override
    public void send(String message) {
        System.out.println("Sending Email Notification: " + message);
    }
}
