package practice.decorator.part4.practice2.component;

public class SmsNotification implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("SMS sent successfully: " + message);
    }
}