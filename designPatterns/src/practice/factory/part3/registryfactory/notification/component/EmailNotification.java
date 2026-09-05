package practice.factory.part3.registryfactory.notification.component;

public class EmailNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
