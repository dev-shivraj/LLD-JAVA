package practice.observer.part4.example1.strategy;

public class EmailNotificationStrategy implements NotificationStrategy {

    @Override
    public void send(String customerId, String message) {
        System.out.println("Email to " + customerId + ": " + message);
    }
}