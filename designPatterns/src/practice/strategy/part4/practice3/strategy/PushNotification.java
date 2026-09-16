package practice.strategy.part4.practice3.strategy;

public class PushNotification
        implements NotificationStrategy {

    @Override
    public void send(String message) {
        System.out.println(
                "Sending PUSH: " + message
        );
    }
}