package practice.decorator.part3.practice2.decorator;

import practice.decorator.part3.practice2.component.NotificationService;

public class RetryDecorator extends NotificationServiceDecorator {
    private final int maxAttempts;

    public RetryDecorator(NotificationService notificationService, int maxAttempts) {
        super(notificationService);
        this.maxAttempts = maxAttempts;
    }

    @Override
    public void send(String message) {
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                notificationService.send(message);
                return;
            } catch (RuntimeException exception) {
                System.out.println("[RETRY] Attempt " + attempt + " failed");

                if (attempt == maxAttempts) {
                    throw exception;
                }
            }
        }
    }
}