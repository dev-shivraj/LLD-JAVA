package practice.factory.part3.example3.factorymethod;

import practice.factory.part3.example3.sender.NotificationSender;

public abstract class NotificationCreator {
    protected abstract NotificationSender createNotification();

    public void sendNotification(String message) {
        validate(message);
        NotificationSender sender = createNotification();
        logNotification();
        sender.send(message);
        completeNotification();
    }

    private void validate(String message) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be null or blank");
        }

        System.out.println("Notification validated");
    }

    private void logNotification() {
        System.out.println("Notification logged");
    }

    private void completeNotification() {
        System.out.println("Notification completed");
    }
}