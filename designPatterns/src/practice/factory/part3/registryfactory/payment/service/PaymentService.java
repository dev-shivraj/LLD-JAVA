package practice.factory.part3.registryfactory.payment.service;

import practice.factory.part3.registryfactory.payment.enums.PaymentType;
import practice.factory.part3.registryfactory.payment.component.Payment;
import practice.factory.part3.registryfactory.payment.factory.PaymentFactory;

public class PaymentService {
    private final PaymentFactory factory;

    public PaymentService(PaymentFactory factory) {
        this.factory = factory;
    }

    public void process(PaymentType type, double amount) {
        Payment payment = factory.create(type);
        payment.pay(amount);
    }
}
