package practice.registry.part3.practice2.factory;

import practice.registry.part3.practice2.generator.ReportGenerator;
import practice.registry.part3.practice2.registry.ReportCreatorRegistry;

import java.util.function.Supplier;

public class ReportFactory {

    private final ReportCreatorRegistry registry;

    public ReportFactory(ReportCreatorRegistry registry) {
        this.registry = registry;
    }

    public ReportGenerator create(String type) {
        Supplier<ReportGenerator> creator = registry.get(type);

        return creator.get();
    }
}