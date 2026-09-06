package practice.singleton.part2.examples.logger;

public enum Logger {
    INSTANCE;

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}