package practice.flyweight.part3.example3.extrinsic;

import practice.flyweight.part3.example3.intrinsic.LogLevel;

public class LogEntry {

    private final long timestamp;
    private final String message;
    private final String thread;
    private final LogLevel level;

    public LogEntry(
            long timestamp,
            String message,
            String thread,
            LogLevel level
    ) {
        this.timestamp = timestamp;
        this.message = message;
        this.thread = thread;
        this.level = level;
    }

    public void print() {
        System.out.println(
                "Timestamp: " + timestamp +
                " | Thread: " + thread
        );

        level.print(message);
    }
}