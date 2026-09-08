package practice.factory.part1.practice1;

import practice.factory.part1.practice1.factory.NotificationFactory;
import practice.factory.part1.practice1.sender.NotificationSender;

public class Main {
    public static void main(String[] args) {
        NotificationSender email = NotificationFactory.create("email");
        NotificationSender sms = NotificationFactory.create("sms");
        NotificationSender push = NotificationFactory.create("push");

        email.send("Welcome to our application");
        sms.send("Your OTP is 123456");
        push.send("You have a new notification");
    }
}