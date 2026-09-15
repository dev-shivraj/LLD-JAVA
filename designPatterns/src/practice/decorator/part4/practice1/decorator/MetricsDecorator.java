package practice.decorator.part4.practice1.decorator;

import practice.decorator.part4.practice1.component.PaymentService;

public class MetricsDecorator extends PaymentServiceDecorator {

    public MetricsDecorator(PaymentService paymentService) {
        super(paymentService);
    }

    @Override
    public void pay(double amount) {
        long start = System.currentTimeMillis();
        paymentService.pay(amount);
        long end = System.currentTimeMillis();

        System.out.println("[METRICS] Duration: " + (end - start) + " ms");
    }
}