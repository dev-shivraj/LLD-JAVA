package practice.singleton.part1.logger;

public class LoggerClient {
    public static void main(String[] args) {
        AppLogger logger1 = AppLogger.getInstance();
        AppLogger logger2 = AppLogger.getInstance();

        logger1.log("Application started");
        logger2.log("User logged in");

        System.out.println(logger1 == logger2);
    }
}