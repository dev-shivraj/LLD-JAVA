package practice.strategy.part4.practice2.service;

import practice.strategy.part4.practice2.registry.PaymentRegistry;
import practice.strategy.part4.practice2.strategy.PaymentStrategy;

public class PaymentService {

    private final PaymentRegistry registry;

    public PaymentService(PaymentRegistry registry) {
        this.registry = registry;
    }

    public void pay(String type, double amount) {
        PaymentStrategy strategy = registry.get(type);
        strategy.pay(amount);
    }
}