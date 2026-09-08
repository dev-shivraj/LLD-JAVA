package practice.factory.part3.example3.factorymethod;

import practice.factory.part3.example3.provider.PushProvider;
import practice.factory.part3.example3.sender.NotificationSender;
import practice.factory.part3.example3.sender.PushNotification;

public class PushNotificationCreator extends NotificationCreator {

    @Override
    protected NotificationSender createNotification() {
        PushProvider provider = new PushProvider();
        return new PushNotification(provider);
    }
}