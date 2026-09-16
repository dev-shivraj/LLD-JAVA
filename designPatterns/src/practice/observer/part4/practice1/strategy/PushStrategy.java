package practice.observer.part4.practice1.strategy;

public class PushStrategy implements NotificationStrategy {

    @Override
    public void send(String customerId, String message) {
        System.out.println("Push -> " + customerId + ": " + message);
    }
}