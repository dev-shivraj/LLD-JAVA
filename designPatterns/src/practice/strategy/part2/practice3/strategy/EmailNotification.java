package practice.strategy.part2.practice3.strategy;

public class EmailNotification implements NotificationStrategy {

    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}