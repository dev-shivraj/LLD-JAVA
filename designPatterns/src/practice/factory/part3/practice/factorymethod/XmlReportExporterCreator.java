package practice.factory.part3.practice.factorymethod;

import practice.factory.part3.practice.exporter.ReportExporter;
import practice.factory.part3.practice.exporter.XmlReportExporter;

public class XmlReportExporterCreator extends ReportExporterCreator {

    @Override
    protected ReportExporter createExporter() {
        return new XmlReportExporter();
    }
}