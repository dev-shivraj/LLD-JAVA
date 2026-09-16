package practice.strategy.part4.practice3;

import practice.strategy.part4.practice3.factory.NotificationFactory;
import practice.strategy.part4.practice3.registry.NotificationRegistry;
import practice.strategy.part4.practice3.service.NotificationService;

public class Main {

    public static void main(String[] args) {

        NotificationFactory factory = new NotificationFactory();
        NotificationRegistry registry = new NotificationRegistry();

        registry.register("EMAIL", factory.create("EMAIL"));
        registry.register("SMS", factory.create("SMS"));
        registry.register("PUSH", factory.create("PUSH"));

        NotificationService service = new NotificationService(registry);
        service.send("EMAIL", "Welcome!");
        service.send("SMS", "Your OTP is 1234");
        service.send("PUSH", "You have a new notification");
    }
}