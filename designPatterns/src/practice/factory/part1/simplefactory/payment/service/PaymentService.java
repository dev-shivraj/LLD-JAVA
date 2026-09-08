package practice.factory.part1.simplefactory.payment.service;

import practice.factory.part1.simplefactory.payment.factory.PaymentFactory;
import practice.factory.part1.simplefactory.payment.payment.Payment;

public class PaymentService {
    public void processPayment(String paymentType, double amount) {
        Payment payment = PaymentFactory.createPayment(paymentType);
        payment.pay(amount);
    }
}
