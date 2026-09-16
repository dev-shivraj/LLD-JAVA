package practice.strategy.part2.practice3.service;

import practice.strategy.part2.practice3.strategy.EmailNotification;
import practice.strategy.part2.practice3.strategy.NotificationStrategy;
import practice.strategy.part2.practice3.strategy.PushNotification;
import practice.strategy.part2.practice3.strategy.SmsNotification;

import java.util.HashMap;
import java.util.Map;

public class NotificationService {

    private final Map<String, NotificationStrategy> strategies;

    public NotificationService() {strategies = new HashMap<>();
        strategies.put("EMAIL", new EmailNotification());
        strategies.put("SMS", new SmsNotification());
        strategies.put("PUSH", new PushNotification());
    }

    public void send(String type, String message) {
        NotificationStrategy strategy = strategies.get(type);

        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported notification type: " + type);
        }

        strategy.send(message);
    }
}