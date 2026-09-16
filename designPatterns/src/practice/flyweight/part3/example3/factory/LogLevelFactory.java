package practice.flyweight.part3.example3.factory;

import practice.flyweight.part3.example3.intrinsic.LogLevel;

import java.util.HashMap;
import java.util.Map;

public class LogLevelFactory {

    private final Map<String, LogLevel> levels = new HashMap<>();

    public LogLevel getLevel(String name, int severity) {
        return levels.computeIfAbsent(name, ignored -> new LogLevel(name, severity));
    }
}