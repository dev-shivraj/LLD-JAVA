package practice.decorator.part4.practice2.component;

public class EmailNotification implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Attempting email...");
        throw new RuntimeException("Email service unavailable");
    }
}