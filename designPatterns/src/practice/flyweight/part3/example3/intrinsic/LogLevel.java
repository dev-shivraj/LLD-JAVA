package practice.flyweight.part3.example3.intrinsic;

public class LogLevel {

    private final String name;
    private final int severity;

    public LogLevel(
            String name,
            int severity
    ) {
        this.name = name;
        this.severity = severity;
    }

    public void print(String message) {
        System.out.println(
                "[" + name + "] " + message +
                " | Severity: " + severity
        );
    }
}