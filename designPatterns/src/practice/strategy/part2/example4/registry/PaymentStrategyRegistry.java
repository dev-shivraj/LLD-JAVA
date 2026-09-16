package practice.strategy.part2.example4.registry;

import practice.strategy.part2.example4.strategy.PaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class PaymentStrategyRegistry {

    private final Map<String, PaymentStrategy> strategies = new HashMap<>();

    public void register(String type, PaymentStrategy strategy) {
        strategies.put(type.toUpperCase(), strategy);
    }

    public PaymentStrategy getStrategy(String type) {
        PaymentStrategy strategy = strategies.get(type.toUpperCase());

        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported payment type: " + type);
        }

        return strategy;
    }
}