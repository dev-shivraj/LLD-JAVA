package practice.registry.part1.practice3;

import practice.registry.part1.practice3.logger.ConsoleLogger;
import practice.registry.part1.practice3.logger.DatabaseLogger;
import practice.registry.part1.practice3.logger.FileLogger;
import practice.registry.part1.practice3.logger.Logger;
import practice.registry.part1.practice3.registry.LoggerRegistry;

public class Main {
    public static void main(String[] args) {
        LoggerRegistry registry = new LoggerRegistry();

        registry.register("console", new ConsoleLogger());
        registry.register("file", new FileLogger());
        registry.register("database", new DatabaseLogger());

        Logger consoleLogger = registry.get("console");
        consoleLogger.log("Application started");

        Logger fileLogger = registry.get("file");
        fileLogger.log("User logged in");

        Logger databaseLogger = registry.get("database");
        databaseLogger.log("Order created");

        // will throw error as already console logger exists
        // registry implementation for already exists logger can vary depending on the business requirement
        // registry.register("console", new ConsoleLogger());

        Logger logger1 = registry.get("console");
        Logger logger2 = registry.get("console");
        System.out.println(logger1 == logger2); // true
    }
}