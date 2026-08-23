package practice.ocp.part1.notification.goodDesign.newRequirement;

import practice.ocp.part1.notification.goodDesign.Notification;

public class WhatsAppNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending notification through WhatsApp");
    }
}