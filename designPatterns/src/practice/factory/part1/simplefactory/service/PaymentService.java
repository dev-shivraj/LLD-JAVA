package practice.factory.part1.simplefactory.service;

import practice.factory.part1.simplefactory.factory.PaymentFactory;
import practice.factory.part1.simplefactory.payment.Payment;

public class PaymentService {
    public void processPayment(String paymentType, double amount) {
        Payment payment = PaymentFactory.createPayment(paymentType);
        payment.pay(amount);
    }
}
