package practice.adapter.part1.payment.service;

import practice.adapter.part1.payment.PaymentProcessor;

public class CheckoutService {
    PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double amount) {
        System.out.println("Starting checkout...");
        paymentProcessor.pay(amount);
        System.out.println("Checkout completed.");
    }
}
