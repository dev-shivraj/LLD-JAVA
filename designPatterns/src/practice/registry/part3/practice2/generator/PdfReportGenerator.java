package practice.registry.part3.practice2.generator;

public class PdfReportGenerator implements ReportGenerator {

    public PdfReportGenerator() {
        System.out.println("Creating PdfReportGenerator");
    }

    @Override
    public void generate(String data) {
        System.out.println("Generating PDF report: " + data);
    }
}