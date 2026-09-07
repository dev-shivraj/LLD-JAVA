package practice.registry.part2.example1;

import practice.registry.part2.example1.handler.EmailNotificationHandler;
import practice.registry.part2.example1.handler.PushNotificationHandler;
import practice.registry.part2.example1.handler.SmsNotificationHandler;
import practice.registry.part2.example1.handler.WhatsAppNotificationHandler;
import practice.registry.part2.example1.registry.NotificationRegistry;
import practice.registry.part2.example1.service.NotificationService;

public class Main {

    public static void main(String[] args) {
        NotificationRegistry registry = new NotificationRegistry();
        registry.register("email", new EmailNotificationHandler());
        registry.register("sms", new SmsNotificationHandler());
        registry.register("push", new PushNotificationHandler());
        registry.register("whatsapp", new WhatsAppNotificationHandler());


        NotificationService service = new NotificationService(registry);
        service.send("email", "Welcome to our platform");
        service.send("sms", "Your OTP is 123456");
        service.send("push", "You have a new notification");
        service.send("whatsapp", "Your order has been shipped");
    }
}