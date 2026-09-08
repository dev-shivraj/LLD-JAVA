package practice.factory.part3.practice.factorymethod;

import practice.factory.part3.practice.exporter.CsvReportExporter;
import practice.factory.part3.practice.exporter.ReportExporter;

public class CsvReportExporterCreator extends ReportExporterCreator {

    @Override
    protected ReportExporter createExporter() {
        return new CsvReportExporter();
    }
}