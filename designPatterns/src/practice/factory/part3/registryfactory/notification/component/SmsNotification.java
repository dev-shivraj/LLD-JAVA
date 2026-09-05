package practice.factory.part3.registryfactory.notification.component;

public class SmsNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}
