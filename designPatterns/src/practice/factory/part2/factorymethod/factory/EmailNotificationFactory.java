package practice.factory.part2.factorymethod.factory;

import practice.factory.part2.factorymethod.component.EmailNotification;
import practice.factory.part2.factorymethod.component.Notification;

public class EmailNotificationFactory extends NotificationFactory{
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
