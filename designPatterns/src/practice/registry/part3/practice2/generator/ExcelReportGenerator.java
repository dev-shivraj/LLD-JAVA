package practice.registry.part3.practice2.generator;

public class ExcelReportGenerator implements ReportGenerator {

    public ExcelReportGenerator() {
        System.out.println("Creating ExcelReportGenerator");
    }

    @Override
    public void generate(String data) {
        System.out.println("Generating EXCEL report: " + data);
    }
}