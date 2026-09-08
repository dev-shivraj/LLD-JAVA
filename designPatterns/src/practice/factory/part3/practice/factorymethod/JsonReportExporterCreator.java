package practice.factory.part3.practice.factorymethod;

import practice.factory.part3.practice.exporter.JsonReportExporter;
import practice.factory.part3.practice.exporter.ReportExporter;

public class JsonReportExporterCreator extends ReportExporterCreator {

    @Override
    protected ReportExporter createExporter() {
        return new JsonReportExporter();
    }
}