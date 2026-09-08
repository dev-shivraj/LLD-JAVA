package practice.factory.part3.example3.factorymethod;

import practice.factory.part3.example3.provider.SmsProvider;
import practice.factory.part3.example3.sender.NotificationSender;
import practice.factory.part3.example3.sender.SmsNotification;

public class SmsNotificationCreator extends NotificationCreator {

    @Override
    protected NotificationSender createNotification() {
        SmsProvider provider = new SmsProvider();
        return new SmsNotification(provider);
    }
}