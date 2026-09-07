package practice.registry.part3.practice2.generator;

public class CsvReportGenerator implements ReportGenerator {

    public CsvReportGenerator() {
        System.out.println("Creating CsvReportGenerator");
    }

    @Override
    public void generate(String data) {
        System.out.println("Generating CSV report: " + data);
    }
}