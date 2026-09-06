package practice.registry.part1.basic;

import practice.registry.part1.basic.registry.ServiceRegistry;
import practice.registry.part1.basic.service.EmailService;
import practice.registry.part1.basic.service.Service;
import practice.registry.part1.basic.service.SmsService;

public class Client {
    public static void main(String[] args) {
        ServiceRegistry registry = new ServiceRegistry();
        registry.register("email", new EmailService());
        registry.register("sms", new SmsService());

        Service emailService = registry.get("email");
        Service smsService = registry.get("sms");

        emailService.execute();
        smsService.execute();
    }
}