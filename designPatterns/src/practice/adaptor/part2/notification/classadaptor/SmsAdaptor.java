package practice.adaptor.part2.notification.classadaptor;

import practice.adaptor.part1.notification.external.SmsGateway;

public class SmsAdaptor extends SmsGateway {
    @Override
    public void sendSms(String recipient, String message) {
        super.sendSms(recipient, message);
    }
}
