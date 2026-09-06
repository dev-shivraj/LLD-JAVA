package practice.registry.part1.practice3.logger;

public class DatabaseLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Database: " + message);
    }
}