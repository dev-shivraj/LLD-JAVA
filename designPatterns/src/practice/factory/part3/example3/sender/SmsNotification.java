package practice.factory.part3.example3.sender;

import practice.factory.part3.example3.provider.SmsProvider;

public class SmsNotification implements NotificationSender {

    private final SmsProvider provider;

    public SmsNotification(SmsProvider provider) {
        this.provider = provider;
    }

    @Override
    public void send(String message) {
        provider.sendSms(message);
    }
}