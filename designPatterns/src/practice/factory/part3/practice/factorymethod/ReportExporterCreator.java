package practice.factory.part3.practice.factorymethod;

import practice.factory.part3.practice.exporter.ReportExporter;

public abstract class ReportExporterCreator {

    protected abstract ReportExporter createExporter();

    public void exportReport(String report) {
        validate(report);
        ReportExporter exporter = createExporter();
        exporter.export(report);
        logExport();
        completeExport();
    }

    private void validate(String report) {
        if (report == null || report.isBlank()) {
            throw new IllegalArgumentException("Report cannot be null or blank");
        }

        System.out.println("Report validated");
    }

    private void logExport() {
        System.out.println("Export logged");
    }

    private void completeExport() {
        System.out.println("Export completed");
    }
}