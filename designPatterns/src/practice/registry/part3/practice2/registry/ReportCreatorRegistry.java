package practice.registry.part3.practice2.registry;

import practice.registry.part3.practice2.generator.ReportGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ReportCreatorRegistry {

    private final Map<String, Supplier<ReportGenerator>> creators = new HashMap<>();

    public void register(String type, Supplier<ReportGenerator> creator) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }

        if (creator == null) {
            throw new IllegalArgumentException("Creator cannot be null");
        }

        if (creators.containsKey(type)) {
            throw new IllegalArgumentException("Creator already registered for type: " + type);
        }

        creators.put(type, creator);
    }

    public Supplier<ReportGenerator> get(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }

        Supplier<ReportGenerator> creator = creators.get(type);

        if (creator == null) {
            throw new IllegalArgumentException("No creator registered for type: " + type);
        }

        return creator;
    }
}