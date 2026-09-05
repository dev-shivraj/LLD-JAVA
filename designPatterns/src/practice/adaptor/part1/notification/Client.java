package practice.adaptor.part1.notification;

import practice.adaptor.part1.notification.adaptor.SmsAdaptor;
import practice.adaptor.part1.notification.component.NotificationService;
import practice.adaptor.part1.notification.external.SmsGateway;

public class Client {
    public static void main(String[] args) {
        SmsGateway gateway = new SmsGateway();
        NotificationService service = new SmsAdaptor(gateway);
        service.send("9933223344", "Your OTP is 123456");
    }
}
