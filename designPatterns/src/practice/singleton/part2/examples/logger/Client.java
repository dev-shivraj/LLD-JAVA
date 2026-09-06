package practice.singleton.part2.examples.logger;

public class Client {
    public static void main(String[] args) {
        Logger logger1 = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;

        logger1.log("Application started");
        System.out.println(logger1 == logger2);
    }
}