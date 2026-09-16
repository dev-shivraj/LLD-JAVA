package practice.observer.part4.example1.strategy;

public interface NotificationStrategy {
    void send(String customerId, String message);
}