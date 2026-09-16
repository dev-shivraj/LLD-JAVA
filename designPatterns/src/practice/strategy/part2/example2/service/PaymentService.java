package practice.strategy.part2.example2.service;

import practice.strategy.part2.example2.strategy.PaymentStrategy;

public class PaymentService {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy is not configured");
        }

        paymentStrategy.pay(amount);
    }
}