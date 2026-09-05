package practice.adaptor.part1.payment.service;

import practice.adaptor.part1.payment.PaymentProcessor;

public class PaymentService {
    PaymentProcessor paymentProcessor;

    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void processPayment(double amount) {
        paymentProcessor.pay(amount);
    }
}
