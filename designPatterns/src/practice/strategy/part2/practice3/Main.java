package practice.strategy.part2.practice3;

import practice.strategy.part2.practice3.service.NotificationService;

public class Main {

    public static void main(String[] args) {

        NotificationService notificationService = new NotificationService();
        notificationService.send("EMAIL", "Welcome to our application!");
        notificationService.send("SMS", "Your OTP is 1234");
        notificationService.send("PUSH", "You have a new notification");
    }
}