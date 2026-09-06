package practice.singleton.part1.app;

public class Application {
    private static Application instance = new Application();

    private Application() {
    }

    public static Application getInstance() {
        return instance;
    }

    public void start() {
        System.out.println("Application started");
    }
}