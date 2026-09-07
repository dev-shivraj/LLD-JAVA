package practice.registry.part2.practice2;

import practice.registry.part2.practice2.logger.ConsoleLogger;
import practice.registry.part2.practice2.logger.DatabaseLogger;
import practice.registry.part2.practice2.logger.FileLogger;
import practice.registry.part2.practice2.registry.LoggerRegistry;
import practice.registry.part2.practice2.service.LoggingService;

public class Main {

    public static void main(String[] args) {
        LoggerRegistry registry = new LoggerRegistry();
        registry.register("console", new ConsoleLogger());
        registry.register("file", new FileLogger());
        registry.register("database", new DatabaseLogger());

        LoggingService service = new LoggingService(registry);
        service.log("console", "Application started");
        service.log("file", "User logged in");
        service.log("database", "Order created");
    }
}