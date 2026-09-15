package practice.decorator.part4.practice1.decorator;

import practice.decorator.part4.practice1.component.PaymentService;

public abstract class PaymentServiceDecorator implements PaymentService {
    protected final PaymentService paymentService;

    protected PaymentServiceDecorator(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void pay(double amount) {
        paymentService.pay(amount);
    }
}