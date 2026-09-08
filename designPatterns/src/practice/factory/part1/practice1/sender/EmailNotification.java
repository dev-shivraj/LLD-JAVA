package practice.factory.part1.practice1.sender;

public class EmailNotification implements NotificationSender {

    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}