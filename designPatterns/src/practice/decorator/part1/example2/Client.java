package practice.decorator.part1.example2;

import practice.decorator.part1.example2.decorator.SlackDecorator;
import practice.decorator.part1.example2.decorator.SmsDecorator;
import practice.decorator.part1.example2.component.BasicNotification;
import practice.decorator.part1.example2.component.Notification;

public class Client {

    public static void main(String[] args) {

        Notification notification = new BasicNotification();
        notification = new SmsDecorator(notification);
        notification = new SlackDecorator(notification);

        notification.send("Payment successful");
    }
}