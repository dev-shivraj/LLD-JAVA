package practice.factory.part1.registryfactory.notification.component;

public class SmsNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}
