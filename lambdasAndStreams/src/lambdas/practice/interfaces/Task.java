package lambdas.practice.interfaces;

@FunctionalInterface
public interface Task {
    void execute();

    default void log() {
        System.out.println("Logging....");
    }

    static void info() {
        System.out.println("Task interface.");
    }
}
