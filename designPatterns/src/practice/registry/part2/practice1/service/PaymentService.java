package practice.registry.part2.practice1.service;

import practice.registry.part2.practice1.registry.PaymentRegistry;
import practice.registry.part2.practice1.processor.PaymentProcessor;

public class PaymentService {

    private final PaymentRegistry registry;

    public PaymentService(PaymentRegistry registry) {
        this.registry = registry;
    }

    public void pay(String type, double amount) {
        PaymentProcessor processor = registry.get(type);
        processor.pay(amount);
    }
}