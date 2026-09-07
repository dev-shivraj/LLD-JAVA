package practice.registry.part4.example2.service;

import practice.registry.part4.example2.registry.Registry;
import practice.registry.part4.example2.processor.PaymentProcessor;

public class PaymentService {

    private final Registry<PaymentProcessor> registry;

    public PaymentService(Registry<PaymentProcessor> registry) {
        this.registry = registry;
    }

    public void pay(String type, double amount) {
        PaymentProcessor processor = registry.get(type);
        processor.pay(amount);
    }
}