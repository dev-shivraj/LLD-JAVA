package practice.flyweight.part3.example3;

import practice.flyweight.part3.example3.extrinsic.LogEntry;
import practice.flyweight.part3.example3.factory.LogLevelFactory;
import practice.flyweight.part3.example3.intrinsic.LogLevel;

public class Client {

    public static void main(String[] args) {

        LogLevelFactory factory = new LogLevelFactory();

        LogLevel info = factory.getLevel("INFO", 1);
        LogLevel infoAgain = factory.getLevel("INFO", 1);
        LogLevel error = factory.getLevel("ERROR", 4);

        LogEntry entry1 = new LogEntry(1000, "Application started", "main", info);
        LogEntry entry2 = new LogEntry(2000, "User logged in", "http-worker-1", infoAgain);
        LogEntry entry3 = new LogEntry(3000, "Database connection failed", "http-worker-2", error);

        entry1.print();
        entry2.print();
        entry3.print();

        System.out.println();
        System.out.println("info == infoAgain: " + (info == infoAgain));
        System.out.println("info == error: " + (info == error));
    }
}