package practice.decorator.part4.practice1;

import practice.decorator.part4.practice1.component.BasicPaymentService;
import practice.decorator.part4.practice1.component.PaymentService;
import practice.decorator.part4.practice1.decorator.AuditDecorator;
import practice.decorator.part4.practice1.decorator.LoggingDecorator;
import practice.decorator.part4.practice1.decorator.MetricsDecorator;

public class Client {

    public static void main(String[] args) {
        PaymentService paymentService = new BasicPaymentService();

        paymentService = new MetricsDecorator(paymentService);
        paymentService = new AuditDecorator(paymentService);
        paymentService = new LoggingDecorator(paymentService);

        paymentService.pay(5000);
    }
}