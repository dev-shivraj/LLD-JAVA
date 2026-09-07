package practice.registry.part3.practice2.service;

import practice.registry.part3.practice2.factory.ReportFactory;
import practice.registry.part3.practice2.generator.ReportGenerator;

public class ReportService {

    private final ReportFactory factory;

    public ReportService(ReportFactory factory) {
        this.factory = factory;
    }

    public void generate(String type, String data) {
        ReportGenerator generator = factory.create(type);
        generator.generate(data);
    }
}