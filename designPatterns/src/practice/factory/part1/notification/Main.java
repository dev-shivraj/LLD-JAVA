package practice.factory.part1.notification;

public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        service.sendNotification("EMAIL", "Your order has been shipped.");
        service.sendNotification("SMS", "Your OTP is 123456.");
        service.sendNotification("PUSH", "You have a new notification.");
    }
}