package practice.strategy.part2.practice3.strategy;

public class PushNotification implements NotificationStrategy {

    @Override
    public void send(String message) {
        System.out.println("Sending PUSH notification: " + message);
    }
}