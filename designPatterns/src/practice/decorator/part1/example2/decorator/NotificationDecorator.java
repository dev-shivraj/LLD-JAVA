package practice.decorator.part1.example2.decorator;

import practice.decorator.part1.example2.component.Notification;

public abstract class NotificationDecorator implements Notification {

    protected Notification notification;

    protected NotificationDecorator(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void send(String message) {
        notification.send(message);
    }
}