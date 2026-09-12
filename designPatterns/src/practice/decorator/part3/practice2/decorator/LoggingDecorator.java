package practice.decorator.part3.practice2.decorator;

import practice.decorator.part3.practice2.component.NotificationService;

public class LoggingDecorator extends NotificationServiceDecorator {

    public LoggingDecorator(NotificationService notificationService) {
        super(notificationService);
    }

    @Override
    public void send(String message) {
        System.out.println("[LOG] Sending started");
        notificationService.send(message);
        System.out.println("[LOG] Sending completed");
    }
}