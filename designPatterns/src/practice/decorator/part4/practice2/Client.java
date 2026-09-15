package practice.decorator.part4.practice2;

import practice.decorator.part4.practice2.component.EmailNotification;
import practice.decorator.part4.practice2.component.NotificationService;
import practice.decorator.part4.practice2.component.SmsNotification;
import practice.decorator.part4.practice2.decorator.FallbackDecorator;
import practice.decorator.part4.practice2.decorator.LoggingDecorator;
import practice.decorator.part4.practice2.decorator.RetryDecorator;

public class Client {

    public static void main(String[] args) {
        NotificationService email = new EmailNotification();

        NotificationService sms = new SmsNotification();
        NotificationService service = new RetryDecorator(email, 3);

        service = new FallbackDecorator(service, sms);
        service = new LoggingDecorator(service);

        service.send("Your OTP is 123456");
    }
}