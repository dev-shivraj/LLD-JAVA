package practice.registry.part1.example3;

import practice.registry.part1.example3.handler.EmailNotificationHandler;
import practice.registry.part1.example3.handler.SmsNotificationHandler;
import practice.registry.part1.example3.registry.NotificationRegistry;
import practice.registry.part1.example3.service.NotificationService;

public class Main {

    public static void main(String[] args) {
        NotificationRegistry registry = new NotificationRegistry();
        registry.register("email", new EmailNotificationHandler());
        registry.register("sms", new SmsNotificationHandler());


        NotificationService service = new NotificationService(registry);
        service.send("email", "Welcome!");
        service.send("sms", "Your OTP is 123456");
    }
}