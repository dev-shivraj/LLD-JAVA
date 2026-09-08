package practice.factory.part2.practice2;

public class PdfReportExporter implements ReportExporter {
    @Override
    public void export(String data) {
        System.out.println(
                "Exporting report to PDF: " + data
        );
    }
}