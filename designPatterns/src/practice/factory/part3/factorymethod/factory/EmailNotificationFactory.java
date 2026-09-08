package practice.factory.part3.factorymethod.factory;

import practice.factory.part3.factorymethod.component.EmailNotification;
import practice.factory.part3.factorymethod.component.Notification;

public class EmailNotificationFactory extends NotificationFactory{
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
