package practice.decorator.part3.example1.decorator;

import practice.decorator.part3.example1.component.PaymentService;

public class LoggingDecorator extends PaymentServiceDecorator {

    public LoggingDecorator(PaymentService paymentService) {
        super(paymentService);
    }

    @Override
    public void pay(double amount) {
        System.out.println("[LOG] Payment started");
        paymentService.pay(amount);
        System.out.println("[LOG] Payment completed");
    }
}