package practice.decorator.part4.example1;

import practice.decorator.part4.example1.component.EmailNotification;
import practice.decorator.part4.example1.component.NotificationService;
import practice.decorator.part4.example1.decorator.LoggingDecorator;
import practice.decorator.part4.example1.decorator.MetricsDecorator;
import practice.decorator.part4.example1.decorator.RetryDecorator;

public class Client {
    public static void main(String[] args) {
        NotificationService notificationService = new EmailNotification();
        notificationService = new RetryDecorator(notificationService, 3);
        notificationService = new MetricsDecorator(notificationService);
        notificationService = new LoggingDecorator(notificationService);
        notificationService.send("Your order has been shipped.");
    }
}