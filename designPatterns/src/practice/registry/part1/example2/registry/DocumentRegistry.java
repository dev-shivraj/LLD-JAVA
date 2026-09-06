package practice.registry.part1.example2.registry;

import practice.registry.part1.example2.processor.DocumentProcessor;

import java.util.HashMap;
import java.util.Map;

public class DocumentRegistry {
    private final Map<String, DocumentProcessor> processors = new HashMap<>();

    public void register(String type, DocumentProcessor processor) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }

        if (processor == null) {
            throw new IllegalArgumentException("Processor cannot be null");
        }

        if (processors.containsKey(type)) {
            throw new IllegalArgumentException("Processor already registered for type: " + type);
        }

        processors.put(type, processor);
    }

    public DocumentProcessor get(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }

        DocumentProcessor processor = processors.get(type);

        if (processor == null) {
            throw new IllegalArgumentException("No processor registered for type: " + type);
        }

        return processor;
    }
}