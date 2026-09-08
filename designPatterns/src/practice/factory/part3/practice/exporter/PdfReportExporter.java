package practice.factory.part3.practice.exporter;

public class PdfReportExporter implements ReportExporter {

    @Override
    public void export(String report) {
        System.out.println(
                "Exporting report as PDF: " + report
        );
    }
}