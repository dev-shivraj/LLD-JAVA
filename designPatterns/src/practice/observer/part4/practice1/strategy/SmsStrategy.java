package practice.observer.part4.practice1.strategy;

public class SmsStrategy implements NotificationStrategy {

    @Override
    public void send(String customerId, String message) {
        System.out.println("SMS -> " + customerId + ": " + message);
    }
}