package practice.strategy.part4.practice2.registry;

import practice.strategy.part4.practice2.strategy.PaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class PaymentRegistry {

    private final Map<String, PaymentStrategy> strategies = new HashMap<>();

    public void register(String type, PaymentStrategy strategy) {
        strategies.put(type, strategy);
    }

    public PaymentStrategy get(String type) {
        PaymentStrategy strategy = strategies.get(type);

        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported payment type: " + type);
        }

        return strategy;
    }
}