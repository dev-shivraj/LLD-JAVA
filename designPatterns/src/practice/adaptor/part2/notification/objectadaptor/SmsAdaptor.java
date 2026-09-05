package practice.adaptor.part2.notification.objectadaptor;

import practice.adaptor.part2.notification.objectadaptor.component.NotificationService;

public class SmsAdaptor implements NotificationService {
    SmsAdaptor smsAdaptor;

    public SmsAdaptor(SmsAdaptor smsAdaptor) {
        this.smsAdaptor = smsAdaptor;
    }

    @Override
    public void send(String recipient, String message) {
        smsAdaptor.send(recipient, message);
    }
}
