package practice.decorator.part3.example1.decorator;

import practice.decorator.part3.example1.component.PaymentService;

public abstract class PaymentServiceDecorator implements PaymentService {

    protected PaymentService paymentService;

    protected PaymentServiceDecorator(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void pay(double amount) {
        paymentService.pay(amount);
    }
}