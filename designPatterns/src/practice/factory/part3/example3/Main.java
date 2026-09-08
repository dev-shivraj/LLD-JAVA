package practice.factory.part3.example3;

import practice.factory.part3.example3.factorymethod.*;

public class Main {

    public static void main(String[] args) {
        NotificationCreator emailCreator = new EmailNotificationCreator();
        emailCreator.sendNotification("Welcome to our application");
        System.out.println();

        NotificationCreator smsCreator = new SmsNotificationCreator();
        smsCreator.sendNotification("Your OTP is 123456");
        System.out.println();

        NotificationCreator pushCreator = new PushNotificationCreator();
        pushCreator.sendNotification("You have a new notification");
        System.out.println();

        NotificationCreator whatsappCreator = new WhatsAppNotificationCreator();
        whatsappCreator.sendNotification("Hello from WhatsApp");
    }
}