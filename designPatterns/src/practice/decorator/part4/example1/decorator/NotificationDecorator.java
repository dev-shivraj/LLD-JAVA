package practice.decorator.part4.example1.decorator;

import practice.decorator.part4.example1.component.NotificationService;

public abstract class NotificationDecorator implements NotificationService {

    protected final NotificationService notificationService;

    protected NotificationDecorator(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void send(String message) {
        notificationService.send(message);
    }
}