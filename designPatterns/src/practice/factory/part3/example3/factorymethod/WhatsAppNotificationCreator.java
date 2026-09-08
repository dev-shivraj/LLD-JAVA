package practice.factory.part3.example3.factorymethod;

import practice.factory.part3.example3.provider.WhatsAppProvider;
import practice.factory.part3.example3.sender.NotificationSender;
import practice.factory.part3.example3.sender.WhatsAppNotification;

public class WhatsAppNotificationCreator extends NotificationCreator {

    @Override
    protected NotificationSender createNotification() {
        WhatsAppProvider provider = new WhatsAppProvider();
        return new WhatsAppNotification(provider);
    }
}