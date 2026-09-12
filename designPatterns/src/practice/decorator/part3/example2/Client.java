package practice.decorator.part3.example2;

import practice.decorator.part3.example2.component.BasicPaymentService;
import practice.decorator.part3.example2.component.PaymentService;
import practice.decorator.part3.example2.decorator.LoggingDecorator;
import practice.decorator.part3.example2.decorator.MetricsDecorator;

public class Client {

    public static void main(String[] args) {

        PaymentService paymentService = new BasicPaymentService();

        paymentService = new LoggingDecorator(paymentService);
        paymentService = new MetricsDecorator(paymentService);

        paymentService.pay(5000);
    }
}