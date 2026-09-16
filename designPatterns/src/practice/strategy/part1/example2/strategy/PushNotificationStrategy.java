package practice.strategy.part1.example2.strategy;

public class PushNotificationStrategy implements NotificationStrategy {

    @Override
    public void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}