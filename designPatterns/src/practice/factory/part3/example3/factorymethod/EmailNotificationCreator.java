package practice.factory.part3.example3.factorymethod;

import practice.factory.part3.example3.provider.EmailProvider;
import practice.factory.part3.example3.sender.EmailNotification;
import practice.factory.part3.example3.sender.NotificationSender;

public class EmailNotificationCreator extends NotificationCreator {

    @Override
    protected NotificationSender createNotification() {
        EmailProvider provider = new EmailProvider();
        return new EmailNotification(provider);
    }
}