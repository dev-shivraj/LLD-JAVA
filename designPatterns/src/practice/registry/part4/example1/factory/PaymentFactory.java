package practice.registry.part4.example1.factory;

import practice.registry.part4.example1.registry.Registry;
import practice.registry.part4.example1.processor.PaymentProcessor;

import java.util.function.Supplier;

public class PaymentFactory {

    private final Registry<PaymentProcessor> registry;

    public PaymentFactory(Registry<PaymentProcessor> registry) {
        this.registry = registry;
    }

    public PaymentProcessor create(String type) {
        Supplier<PaymentProcessor> creator = registry.get(type);

        return creator.get();
    }
}