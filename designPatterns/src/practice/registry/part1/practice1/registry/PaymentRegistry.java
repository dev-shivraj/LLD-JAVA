package practice.registry.part1.practice1.registry;

import practice.registry.part1.practice1.processor.PaymentProcessor;

import java.util.HashMap;
import java.util.Map;

public class PaymentRegistry {
    private final Map<String, PaymentProcessor> processors = new HashMap<>();

    public void register(String key, PaymentProcessor processor) {
        processors.put(key, processor);
    }

    public PaymentProcessor get(String key) {
        return processors.get(key);
    }
}
