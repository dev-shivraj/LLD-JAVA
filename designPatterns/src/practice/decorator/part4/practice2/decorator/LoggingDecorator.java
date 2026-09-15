package practice.decorator.part4.practice2.decorator;

import practice.decorator.part4.practice2.component.NotificationService;

public class LoggingDecorator extends NotificationDecorator {

    public LoggingDecorator(NotificationService notificationService) {
        super(notificationService);
    }

    @Override
    public void send(String message) {

        System.out.println("[LOG] Sending notification");

        try {
            notificationService.send(message);
            System.out.println("[LOG] Success");
        } catch (RuntimeException exception) {
            System.out.println(
                    "[LOG] Failed: " + exception.getMessage()
            );
            throw exception;
        }
    }
}