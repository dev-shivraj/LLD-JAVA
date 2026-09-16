package practice.strategy.part4.practice3.registry;

import practice.strategy.part4.practice3.strategy.NotificationStrategy;

import java.util.HashMap;
import java.util.Map;

public class NotificationRegistry {

    private final Map<String, NotificationStrategy>
            strategies = new HashMap<>();

    public void register(
            String type,
            NotificationStrategy strategy
    ) {
        strategies.put(type, strategy);
    }

    public NotificationStrategy get(String type) {

        NotificationStrategy strategy =
                strategies.get(type);

        if (strategy == null) {
            throw new IllegalArgumentException(
                    "Unsupported notification type: " + type
            );
        }

        return strategy;
    }
}