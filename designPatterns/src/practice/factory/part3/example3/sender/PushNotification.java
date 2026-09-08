package practice.factory.part3.example3.sender;

import practice.factory.part3.example3.provider.PushProvider;

public class PushNotification implements NotificationSender {

    private final PushProvider provider;

    public PushNotification(PushProvider provider) {
        this.provider = provider;
    }

    @Override
    public void send(String message) {
        provider.sendPush(message);
    }
}