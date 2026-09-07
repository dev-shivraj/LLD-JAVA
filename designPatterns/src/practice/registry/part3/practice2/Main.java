package practice.registry.part3.practice2;

import practice.registry.part3.practice2.factory.ReportFactory;
import practice.registry.part3.practice2.generator.CsvReportGenerator;
import practice.registry.part3.practice2.generator.ExcelReportGenerator;
import practice.registry.part3.practice2.generator.PdfReportGenerator;
import practice.registry.part3.practice2.registry.ReportCreatorRegistry;
import practice.registry.part3.practice2.service.ReportService;

public class Main {

    public static void main(String[] args) {
        ReportCreatorRegistry registry = new ReportCreatorRegistry();
        registry.register("pdf", PdfReportGenerator::new);
        registry.register("excel", ExcelReportGenerator::new);
        registry.register("csv", CsvReportGenerator::new);

        ReportFactory factory = new ReportFactory(registry);
        ReportService service = new ReportService(factory);
        service.generate("pdf", "Sales Report");
        service.generate("excel", "Employee Report");
        service.generate("csv", "Transaction Report");
        service.generate("pdf", "Monthly Report");
    }
}