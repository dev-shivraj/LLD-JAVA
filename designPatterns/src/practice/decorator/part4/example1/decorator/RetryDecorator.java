package practice.decorator.part4.example1.decorator;

import practice.decorator.part4.example1.component.NotificationService;

public class RetryDecorator extends NotificationDecorator {

    private final int maxAttempts;

    public RetryDecorator(NotificationService notificationService, int maxAttempts) {
        super(notificationService);
        this.maxAttempts = maxAttempts;
    }

    @Override
    public void send(String message) {
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                System.out.println("[RETRY] Attempt " + attempt);
                notificationService.send(message);
                return;
            } catch (RuntimeException exception) {
                if (attempt == maxAttempts) {
                    throw exception;
                }
                System.out.println("[RETRY] Retrying...");
            }
        }
    }
}