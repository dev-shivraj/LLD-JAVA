package practice.factory.part2.practice2;

public class ReportService {
    public void export(String type, String data) {
        ReportExporter exporter =
                ReportExporterFactory.create(type);

        exporter.export(data);
    }
}