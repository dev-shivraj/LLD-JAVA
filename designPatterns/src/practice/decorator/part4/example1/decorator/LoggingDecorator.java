package practice.decorator.part4.example1.decorator;

import practice.decorator.part4.example1.component.NotificationService;

public class LoggingDecorator extends NotificationDecorator {

    public LoggingDecorator(NotificationService notificationService) {
        super(notificationService);
    }

    @Override
    public void send(String message) {
        System.out.println("[LOG] Notification started");

        notificationService.send(message);

        System.out.println("[LOG] Notification completed");
    }
}