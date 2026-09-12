package practice.decorator.part3.practice2;

import practice.decorator.part3.practice2.component.NotificationService;
import practice.decorator.part3.practice2.component.UnstableNotificationService;
import practice.decorator.part3.practice2.decorator.LoggingDecorator;
import practice.decorator.part3.practice2.decorator.RetryDecorator;

public class Client {

    public static void main(String[] args) {
        NotificationService notificationService = new UnstableNotificationService();
        notificationService = new RetryDecorator(notificationService, 3);
        notificationService = new LoggingDecorator(notificationService);
        notificationService.send("Hello");
    }
}