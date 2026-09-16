package practice.strategy.part1.example2;

import practice.strategy.part1.example2.service.NotificationService;
import practice.strategy.part1.example2.strategy.EmailNotificationStrategy;
import practice.strategy.part1.example2.strategy.PushNotificationStrategy;
import practice.strategy.part1.example2.strategy.SmsNotificationStrategy;

public class Client {

    public static void main(String[] args) {

        NotificationService emailService = new NotificationService(new EmailNotificationStrategy());
        emailService.sendNotification("Order placed successfully");


        NotificationService smsService = new NotificationService(new SmsNotificationStrategy());
        smsService.sendNotification("Your OTP is 123456");


        NotificationService pushService = new NotificationService(new PushNotificationStrategy());
        pushService.sendNotification("You have a new message");
    }
}