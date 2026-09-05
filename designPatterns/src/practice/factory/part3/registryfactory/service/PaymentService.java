package practice.factory.part3.registryfactory.service;

import practice.factory.part3.registryfactory.component.Payment;
import practice.factory.part3.registryfactory.factory.PaymentFactory;

public class PaymentService {
    private final PaymentFactory factory;

    public PaymentService(PaymentFactory factory) {
        this.factory = factory;
    }

    public void process(String type, double amount) {
        Payment payment = factory.create(type);
        payment.pay(amount);
    }
}
