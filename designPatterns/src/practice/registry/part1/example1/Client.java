package practice.registry.part1.example1;

import practice.registry.part1.example1.handler.EmailNotificationHandler;
import practice.registry.part1.example1.handler.NotificationHandler;
import practice.registry.part1.example1.handler.PushNotificationHandler;
import practice.registry.part1.example1.handler.SmsNotificationHandler;
import practice.registry.part1.example1.handler.newhandler.WhatsAppNotificationHandler;
import practice.registry.part1.example1.registry.NotificationRegistry;

public class Client {
    public static void main(String[] args) {
        NotificationRegistry registry = new NotificationRegistry();
        registry.register("email", new EmailNotificationHandler());
        registry.register("sms", new SmsNotificationHandler());
        registry.register("push", new PushNotificationHandler());

        // new handler added due to business requirement
        registry.register("whatsapp", new WhatsAppNotificationHandler());

        NotificationHandler emailHandler = registry.get("email");
        emailHandler.send("Welcome to the application!");

        NotificationHandler smsHandler = registry.get("sms");
        smsHandler.send("Your OTP is 123456");

        NotificationHandler pushHandler = registry.get("push");
        pushHandler.send("You have a new notification");

        NotificationHandler whatsappHandler = registry.get("whatsapp");
        whatsappHandler.send("Hello!");
    }
}
