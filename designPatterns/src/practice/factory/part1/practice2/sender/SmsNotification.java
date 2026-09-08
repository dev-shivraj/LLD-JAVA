package practice.factory.part1.practice2.sender;

import practice.factory.part1.practice2.notificationclient.SmsClient;

public class SmsNotification implements NotificationSender {

    private final SmsClient smsClient;

    public SmsNotification(SmsClient smsClient) {
        this.smsClient = smsClient;
    }

    @Override
    public void send(String message) {
        smsClient.sendSms(message);
    }
}