package practice.factory.part3.factorymethod.factory;

import practice.factory.part3.factorymethod.component.Notification;
import practice.factory.part3.factorymethod.component.SmsNotification;

public class SmsNotificationFactory extends NotificationFactory{
    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}
