package practice.adapter.part2.objectadapter;

import practice.adapter.part2.objectadapter.component.NotificationService;

public class SmsAdapter implements NotificationService {
    SmsAdapter smsAdapter;

    public SmsAdapter(SmsAdapter smsAdapter) {
        this.smsAdapter = smsAdapter;
    }

    @Override
    public void send(String recipient, String message) {
        smsAdapter.send(recipient, message);
    }
}
