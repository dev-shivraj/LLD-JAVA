package practice.decorator.part3.example2.decorator;

import practice.decorator.part3.example2.component.PaymentService;

public class MetricsDecorator extends PaymentServiceDecorator {

    public MetricsDecorator(PaymentService paymentService) {
        super(paymentService);
    }

    @Override
    public void pay(double amount) {
        long startTime = System.nanoTime();
        paymentService.pay(amount);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("[METRICS] Execution time: " + duration + " ns");
    }
}