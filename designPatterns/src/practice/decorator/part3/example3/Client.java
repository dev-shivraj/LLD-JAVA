package practice.decorator.part3.example3;

import practice.decorator.part3.example3.component.PaymentService;
import practice.decorator.part3.example3.component.UnstablePaymentService;
import practice.decorator.part3.example3.decorator.RetryDecorator;

public class Client {

    public static void main(String[] args) {
        PaymentService paymentService = new UnstablePaymentService();
        paymentService = new RetryDecorator(paymentService, 3);
        paymentService.pay(1000);
    }
}