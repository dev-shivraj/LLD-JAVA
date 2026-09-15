package practice.decorator.part4.practice1.decorator;

import practice.decorator.part4.practice1.component.PaymentService;

public class AuditDecorator extends PaymentServiceDecorator {

    public AuditDecorator(PaymentService paymentService) {
        super(paymentService);
    }

    @Override
    public void pay(double amount) {
        System.out.println("[AUDIT] Payment requested for ₹" + amount);
        paymentService.pay(amount);
    }
}