package practice.decorator.part3.practice2.component;

public class UnstableNotificationService implements NotificationService {
    private int attempts;

    @Override
    public void send(String message) {
        attempts++;

        System.out.println("Sending attempt: " + attempts);

        if (attempts < 3) {
            throw new RuntimeException("Notification failed");
        }

        System.out.println("Notification sent: " + message);
    }
}