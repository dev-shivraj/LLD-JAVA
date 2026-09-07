package practice.registry.part3.practice1;

import practice.registry.part3.practice1.factory.NotificationFactory;
import practice.registry.part3.practice1.registry.NotificationCreatorRegistry;
import practice.registry.part3.practice1.sender.EmailSender;
import practice.registry.part3.practice1.sender.PushSender;
import practice.registry.part3.practice1.sender.SmsSender;
import practice.registry.part3.practice1.service.NotificationService;

public class Main {

    public static void main(String[] args) {

        NotificationCreatorRegistry registry =
                new NotificationCreatorRegistry();

        registry.register(
                "email",
                EmailSender::new
        );

        registry.register(
                "sms",
                SmsSender::new
        );

        registry.register(
                "push",
                PushSender::new
        );

        NotificationFactory factory =
                new NotificationFactory(registry);

        NotificationService service =
                new NotificationService(factory);

        service.send("email", "Welcome");
        service.send("sms", "OTP: 1234");
        service.send("push", "New message");
        service.send("email", "Second email");
    }
}