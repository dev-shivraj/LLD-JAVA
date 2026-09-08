package practice.factory.part2.practice2;

public class ReportExporterFactory {
    public static ReportExporter create(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException(
                    "Report type cannot be null or blank"
            );
        }

        return switch (type.toLowerCase()) {
            case "pdf" -> new PdfReportExporter();
            case "csv" -> new CsvReportExporter();
            case "json" -> new JsonReportExporter();
            default -> throw new IllegalArgumentException(
                    "Unknown report type: " + type
            );
        };
    }
}