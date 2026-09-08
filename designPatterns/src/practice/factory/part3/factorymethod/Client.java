package practice.factory.part3.factorymethod;

import practice.factory.part3.factorymethod.factory.EmailNotificationFactory;
import practice.factory.part3.factorymethod.factory.NotificationFactory;

public class Client {
    public static void main(String[] args) {
        NotificationFactory factory = new EmailNotificationFactory();
        factory.sendNotification("Order shipped");
    }
}