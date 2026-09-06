package practice.registry.part1.practice3.logger;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Console: " + message);
    }
}