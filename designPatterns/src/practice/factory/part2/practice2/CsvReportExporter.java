package practice.factory.part2.practice2;

public class CsvReportExporter implements ReportExporter {
    @Override
    public void export(String data) {
        System.out.println(
                "Exporting report to CSV: " + data
        );
    }
}