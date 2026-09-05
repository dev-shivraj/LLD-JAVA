package practice.adapter.part2.classadapter;

import practice.adapter.part1.notification.external.SmsGateway;

public class SmsAdapter extends SmsGateway {
    @Override
    public void sendSms(String recipient, String message) {
        super.sendSms(recipient, message);
    }
}
