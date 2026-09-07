package practice.registry.part2.practice1.registry;

import practice.registry.part2.practice1.processor.PaymentProcessor;

import java.util.HashMap;
import java.util.Map;

public class PaymentRegistry {

    private final Map<String, PaymentProcessor> processors = new HashMap<>();

    public void register(String type, PaymentProcessor processor) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }

        if (processor == null) {
            throw new IllegalArgumentException("Processor cannot be null");
        }

        if (processors.containsKey(type)) {
            throw new IllegalArgumentException("Processor already registered for type: " + type);
        }

        processors.put(type, processor);
    }

    public PaymentProcessor get(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }

        PaymentProcessor processor = processors.get(type);

        if (processor == null) {
            throw new IllegalArgumentException("No processor registered for type: " + type);
        }

        return processor;
    }
}