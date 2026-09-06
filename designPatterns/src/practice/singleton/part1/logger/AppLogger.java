package practice.singleton.part1.logger;

public class AppLogger {
    private static AppLogger instance = new AppLogger();

    private AppLogger() {
    }

    public static AppLogger getInstance() {
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}