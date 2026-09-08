package practice.factory.part2.example1.notification;

public class SmsNotification implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}