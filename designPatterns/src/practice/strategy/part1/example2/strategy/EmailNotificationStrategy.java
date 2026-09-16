package practice.strategy.part1.example2.strategy;

public class EmailNotificationStrategy implements NotificationStrategy {

    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}