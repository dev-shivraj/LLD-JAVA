package practice.registry.part3.example1.factory;

import practice.registry.part3.example1.processor.PaymentProcessor;
import practice.registry.part3.example1.registry.PaymentCreatorRegistry;

import java.util.function.Supplier;

public class PaymentFactory {

    private final PaymentCreatorRegistry registry;

    public PaymentFactory(PaymentCreatorRegistry registry) {
        this.registry = registry;
    }

    public PaymentProcessor create(String type) {
        Supplier<PaymentProcessor> creator = registry.get(type);
        return creator.get();
    }
}