package practice.adapter.part1.notification;

import practice.adapter.part1.notification.adapter.SmsAdapter;
import practice.adapter.part1.notification.component.NotificationService;
import practice.adapter.part1.notification.external.SmsGateway;

public class Client {
    public static void main(String[] args) {
        SmsGateway gateway = new SmsGateway();
        NotificationService service = new SmsAdapter(gateway);
        service.send("9933223344", "Your OTP is 123456");
    }
}
