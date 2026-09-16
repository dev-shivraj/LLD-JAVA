package practice.observer.part4.example1.strategy;

public class PushNotificationStrategy implements NotificationStrategy {

    @Override
    public void send(String customerId, String message) {
        System.out.println("Push notification to " + customerId + ": " + message);
    }
}