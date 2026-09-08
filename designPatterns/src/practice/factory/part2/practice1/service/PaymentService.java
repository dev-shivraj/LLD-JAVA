package practice.factory.part2.practice1.service;

import practice.factory.part2.practice1.processor.PaymentProcessor;
import practice.factory.part2.practice1.factory.PaymentFactory;

public class PaymentService {
    public void process(String type, double amount) {
        PaymentProcessor processor = PaymentFactory.create(type);
        processor.pay(amount);
    }
}