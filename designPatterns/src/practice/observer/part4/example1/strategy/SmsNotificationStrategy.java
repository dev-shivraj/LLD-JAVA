package practice.observer.part4.example1.strategy;

public class SmsNotificationStrategy implements NotificationStrategy {

    @Override
    public void send(String customerId, String message) {
        System.out.println("SMS to " + customerId + ": " + message);
    }
}