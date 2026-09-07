package practice.registry.part2.practice2.service;

import practice.registry.part2.practice2.logger.Logger;
import practice.registry.part2.practice2.registry.LoggerRegistry;

public class LoggingService {

    private final LoggerRegistry registry;

    public LoggingService(LoggerRegistry registry) {
        this.registry = registry;
    }

    public void log(String type, String message) {
        Logger logger = registry.get(type);
        logger.log(message);
    }
}