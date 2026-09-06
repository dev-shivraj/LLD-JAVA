package practice.registry.part1.example1.handler.newhandler;

import practice.registry.part1.example1.handler.NotificationHandler;

public class WhatsAppNotificationHandler implements NotificationHandler {
    @Override
    public void send(String message) {
        System.out.println("Sending WHATSAPP notification: " + message);
    }
}
