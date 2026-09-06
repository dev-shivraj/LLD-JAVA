package practice.registry.part1.practice2.registry;

import practice.registry.part1.practice2.processor.DocumentProcessor;

import java.util.HashMap;
import java.util.Map;

public class DocumentRegistry {
    private final Map<String, DocumentProcessor> processors = new HashMap<>();

    public void register(String type, DocumentProcessor processor) {
        processors.put(type, processor);
    }

    public DocumentProcessor get(String type) {
        return processors.get(type);
    }
}