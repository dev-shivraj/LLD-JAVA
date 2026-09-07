package practice.registry.part2.example1.handler;

public class EmailNotificationHandler implements NotificationHandler {

    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}