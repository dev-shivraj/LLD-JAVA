package practice.factory.part3.practice.exporter;

public class JsonReportExporter implements ReportExporter {

    @Override
    public void export(String report) {
        System.out.println("Exporting report as JSON: " + report);
    }
}