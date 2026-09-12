package practice.decorator.part3.example1;

import practice.decorator.part3.example1.component.BasicPaymentService;
import practice.decorator.part3.example1.component.PaymentService;
import practice.decorator.part3.example1.decorator.LoggingDecorator;

public class Client {
    public static void main(String[] args) {
        PaymentService paymentService = new BasicPaymentService();
        paymentService = new LoggingDecorator(paymentService);
        paymentService.pay(5000);
    }
}