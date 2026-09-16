package practice.strategy.part4.practice3.strategy;

public class SmsNotification
        implements NotificationStrategy {

    @Override
    public void send(String message) {
        System.out.println(
                "Sending SMS: " + message
        );
    }
}