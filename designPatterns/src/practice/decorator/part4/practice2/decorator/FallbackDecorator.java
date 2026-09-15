package practice.decorator.part4.practice2.decorator;

import practice.decorator.part4.practice2.component.NotificationService;

public class FallbackDecorator extends NotificationDecorator {

    private final NotificationService fallbackService;

    public FallbackDecorator(
            NotificationService notificationService,
            NotificationService fallbackService
    ) {
        super(notificationService);
        this.fallbackService = fallbackService;
    }

    @Override
    public void send(String message) {

        try {

            notificationService.send(message);

        } catch (RuntimeException exception) {

            System.out.println(
                    "[FALLBACK] Primary failed"
            );

            fallbackService.send(message);
        }
    }
}