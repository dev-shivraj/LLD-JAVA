package practice.registry.part1.example1.handler;

public class PushNotificationHandler implements NotificationHandler{
    @Override
    public void send(String message) {
        System.out.println("Sending PUSH Notification: " + message);
    }
}
