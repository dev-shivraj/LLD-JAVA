package practice.ocp.part1.notification.goodDesign;

import practice.ocp.part1.notification.goodDesign.newRequirement.WhatsAppNotification;

public class NotificationClient {

    public static void main(String[] args) {
        // existing design
        Notification email = new EmailNotification();
        Notification sms = new SmsNotification();
        Notification push = new PushNotification();


        // new requirement
        Notification whatsapp = new WhatsAppNotification();


        // existing design
        email.send();
        sms.send();
        push.send();


        // new requirement
        whatsapp.send();
    }
}