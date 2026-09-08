package practice.factory.part1.practice2.service;

import practice.factory.part1.practice2.factory.NotificationFactory;
import practice.factory.part1.practice2.sender.NotificationSender;

public class NotificationService {

    public void send(String type, String message) {
        NotificationSender sender = NotificationFactory.create(type);
        sender.send(message);
    }
}