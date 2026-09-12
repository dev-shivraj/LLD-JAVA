package practice.decorator.part3.practice2.decorator;

import practice.decorator.part3.practice2.component.NotificationService;

public abstract class NotificationServiceDecorator implements NotificationService {

    protected NotificationService notificationService;

    protected NotificationServiceDecorator(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void send(String message) {
        notificationService.send(message);
    }
}