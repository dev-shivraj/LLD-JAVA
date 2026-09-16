package practice.strategy.part4.practice3.factory;

import practice.strategy.part4.practice3.strategy.EmailNotification;
import practice.strategy.part4.practice3.strategy.NotificationStrategy;
import practice.strategy.part4.practice3.strategy.PushNotification;
import practice.strategy.part4.practice3.strategy.SmsNotification;

public class NotificationFactory {

    public NotificationStrategy create(String type) {

        return switch (type) {

            case "EMAIL" ->
                    new EmailNotification();

            case "SMS" ->
                    new SmsNotification();

            case "PUSH" ->
                    new PushNotification();

            default ->
                    throw new IllegalArgumentException(
                            "Unsupported notification type: " + type
                    );
        };
    }
}