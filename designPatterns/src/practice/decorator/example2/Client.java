package practice.decorator.example2;

import practice.decorator.example2.decorator.SlackDecorator;
import practice.decorator.example2.decorator.SmsDecorator;
import practice.decorator.example2.service.BasicNotification;
import practice.decorator.example2.service.Notification;

public class Client {

    public static void main(String[] args) {

        Notification notification = new BasicNotification();
        notification = new SmsDecorator(notification);
        notification = new SlackDecorator(notification);

        notification.send("Payment successful");
    }
}