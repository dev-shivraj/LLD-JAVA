package practice.factory.part2.example1;

import practice.factory.part2.example1.service.NotificationService;

public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        service.send("email", "Welcome");
        service.send("sms", "Your OTP is 123456");
        service.send("push", "You have a new message");
    }
}