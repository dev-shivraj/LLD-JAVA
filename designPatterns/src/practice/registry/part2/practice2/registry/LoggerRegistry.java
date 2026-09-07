package practice.registry.part2.practice2.registry;

import practice.registry.part2.practice2.logger.Logger;

import java.util.HashMap;
import java.util.Map;

public class LoggerRegistry {

    private final Map<String, Logger> loggers = new HashMap<>();

    public void register(String type, Logger logger) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }

        if (logger == null) {
            throw new IllegalArgumentException("Logger cannot be null");
        }

        if (loggers.containsKey(type)) {
            throw new IllegalArgumentException("Logger already registered for type: " + type);
        }

        loggers.put(type, logger);
    }

    public Logger get(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }

        Logger logger = loggers.get(type);

        if (logger == null) {
            throw new IllegalArgumentException("No logger registered for type: " + type);
        }

        return logger;
    }
}