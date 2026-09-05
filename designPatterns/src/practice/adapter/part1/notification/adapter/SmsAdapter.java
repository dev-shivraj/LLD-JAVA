package practice.adapter.part1.notification.adapter;

import practice.adapter.part1.notification.component.NotificationService;
import practice.adapter.part1.notification.external.SmsGateway;

public class SmsAdapter implements NotificationService {
    private final SmsGateway gateway;

    public SmsAdapter(SmsGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void send(String recipient, String message) {
        gateway.sendSms(recipient, message);
    }
}
