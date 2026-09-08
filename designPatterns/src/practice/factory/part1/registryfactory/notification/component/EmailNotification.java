package practice.factory.part1.registryfactory.notification.component;

public class EmailNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
