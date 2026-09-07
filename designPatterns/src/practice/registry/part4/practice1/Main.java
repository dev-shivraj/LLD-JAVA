package practice.registry.part4.practice1;

import practice.registry.part4.practice1.registry.Registry;
import practice.registry.part4.practice1.sender.EmailSender;
import practice.registry.part4.practice1.sender.NotificationSender;
import practice.registry.part4.practice1.sender.PushSender;
import practice.registry.part4.practice1.sender.SmsSender;
import practice.registry.part4.practice1.service.NotificationService;

public class Main {

    public static void main(String[] args) {
        Registry<NotificationSender> registry = new Registry<>();
        registry.register("email", EmailSender::new);
        registry.register("sms", SmsSender::new);
        registry.register("push", PushSender::new);

        NotificationService service = new NotificationService(registry);
        service.send("email", "Welcome");
        service.send("email", "Second email");
        service.send("sms", "OTP: 1234");
        service.send("push", "New message");

        NotificationSender sender1 = service.createSender("email");
        NotificationSender sender2 = service.createSender("email");
        System.out.println("Same sender object: " + (sender1 == sender2));
    }
}