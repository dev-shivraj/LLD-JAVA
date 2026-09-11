package practice.decorator.part1.example2.decorator;

import practice.decorator.part1.example2.service.Notification;

public class SmsDecorator extends NotificationDecorator {

    public SmsDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        notification.send(message);
        System.out.println("Sending SMS: " + message);
    }
}