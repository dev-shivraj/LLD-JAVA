package practice.factory.part3.practice.factorymethod;

import practice.factory.part3.practice.exporter.PdfReportExporter;
import practice.factory.part3.practice.exporter.ReportExporter;

public class PdfReportExporterCreator extends ReportExporterCreator {

    @Override
    protected ReportExporter createExporter() {
        return new PdfReportExporter();
    }
}