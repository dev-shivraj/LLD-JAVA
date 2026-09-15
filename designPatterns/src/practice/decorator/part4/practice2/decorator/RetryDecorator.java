package practice.decorator.part4.practice2.decorator;

import practice.decorator.part4.practice2.component.NotificationService;

public class RetryDecorator extends NotificationDecorator {

    private final int maxAttempts;

    public RetryDecorator(NotificationService notificationService, int maxAttempts) {
        super(notificationService);
        this.maxAttempts = maxAttempts;
    }

    @Override
    public void send(String message) {

        RuntimeException lastException = null;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                System.out.println("[RETRY] Attempt " + attempt);
                notificationService.send(message);
                return;
            } catch (RuntimeException exception) {
                lastException = exception;
            }
        }

        throw lastException;
    }
}