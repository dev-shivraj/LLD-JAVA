package practice.registry.part2.practice2.logger;

public class FileLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("FILE: " + message);
    }
}