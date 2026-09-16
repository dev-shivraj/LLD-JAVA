package practice.observer.part3.practice2.strategy;

public class SmsStrategy implements NotificationStrategy {

    @Override
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}