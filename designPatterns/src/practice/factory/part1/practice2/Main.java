package practice.factory.part1.practice2;

import practice.factory.part1.practice2.service.NotificationService;

public class Main {

    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        service.send("email", "Welcome to the application");
        service.send("sms", "Your OTP is 123456");
    }
}