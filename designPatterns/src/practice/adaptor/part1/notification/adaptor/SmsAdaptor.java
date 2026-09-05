package practice.adaptor.part1.notification.adaptor;

import practice.adaptor.part1.notification.component.NotificationService;
import practice.adaptor.part1.notification.external.SmsGateway;

public class SmsAdaptor implements NotificationService {
    private final SmsGateway gateway;

    public SmsAdaptor(SmsGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void send(String recipient, String message) {
        gateway.sendSms(recipient, message);
    }
}
