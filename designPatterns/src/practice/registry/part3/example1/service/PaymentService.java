package practice.registry.part3.example1.service;

import practice.registry.part3.example1.factory.PaymentFactory;
import practice.registry.part3.example1.processor.PaymentProcessor;

public class PaymentService {

    private final PaymentFactory factory;

    public PaymentService(PaymentFactory factory) {
        this.factory = factory;
    }

    public void pay(String type, double amount) {
        PaymentProcessor processor = factory.create(type);
        processor.pay(amount);
    }
}