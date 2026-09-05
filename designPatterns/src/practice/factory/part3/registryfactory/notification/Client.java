package practice.factory.part3.registryfactory.notification;

import practice.factory.part3.registryfactory.notification.component.EmailNotification;
import practice.factory.part3.registryfactory.notification.component.Notification;
import practice.factory.part3.registryfactory.notification.component.PushNotification;
import practice.factory.part3.registryfactory.notification.component.SmsNotification;
import practice.factory.part3.registryfactory.notification.enums.NotificationType;
import practice.factory.part3.registryfactory.notification.factory.NotificationFactory;
import practice.factory.part3.registryfactory.notification.service.NotificationService;

public class Client {
    public static void main(String[] args) {
        // =====================  when only one notification type exists, and we don't need factory ==================
//        Notification notification = new EmailNotification();
//        NotificationService service = new NotificationService(notification);
//        service.sendNotification("Hello");

        // ===========================================================================================================

        // =====================  when factory is needed to implement with many notification type ====================
        NotificationFactory factory = new NotificationFactory();
        factory.register(NotificationType.SMS, SmsNotification::new);
        factory.register(NotificationType.EMAIL, EmailNotification::new);
        factory.register(NotificationType.PUSH, PushNotification::new);

        NotificationService service = new NotificationService(factory);
        service.sendNotification(NotificationType.SMS, "Order shipped");
        service.sendNotification(NotificationType.EMAIL, "OTP: 123456");
        service.sendNotification(NotificationType.PUSH, "You have a new notification");


        // ===========================================================================================================
    }
}
