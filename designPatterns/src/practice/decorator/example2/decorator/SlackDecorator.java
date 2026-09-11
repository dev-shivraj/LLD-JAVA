package practice.decorator.example2.decorator;

import practice.decorator.example2.service.Notification;

public class SlackDecorator extends NotificationDecorator {

    public SlackDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        notification.send(message);
        System.out.println("Sending Slack notification: " + message);
    }
}