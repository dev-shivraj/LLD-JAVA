package practice.factory.part3.practice.exporter;

public class CsvReportExporter implements ReportExporter {

    @Override
    public void export(String report) {
        System.out.println("Exporting report as CSV: " + report);
    }
}