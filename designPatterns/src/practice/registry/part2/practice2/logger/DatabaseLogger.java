package practice.registry.part2.practice2.logger;

public class DatabaseLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("DATABASE: " + message);
    }
}