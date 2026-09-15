package practice.decorator.part4.example1.component;

public class EmailNotification implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}