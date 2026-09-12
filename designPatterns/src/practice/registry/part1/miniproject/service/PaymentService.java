package practice.registry.part1.miniproject.service;

import practice.registry.part1.miniproject.registry.PaymentRegistry;
import practice.registry.part1.miniproject.processor.PaymentProcessor;

public class PaymentService {
    private final PaymentRegistry registry;

    public PaymentService(PaymentRegistry registry) {
        this.registry = registry;
    }

    public void pay(String paymentType, double amount) {
        PaymentProcessor processor = registry.get(paymentType);
        processor.pay(amount);
    }
}