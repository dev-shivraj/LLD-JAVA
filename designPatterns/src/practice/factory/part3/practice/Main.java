package practice.factory.part3.practice;

import practice.factory.part3.practice.factorymethod.*;

public class Main {
    public static void main(String[] args) {
        ReportExporterCreator pdfCreator = new PdfReportExporterCreator();
        pdfCreator.exportReport("Monthly Sales Report");
        System.out.println();

        ReportExporterCreator csvCreator = new CsvReportExporterCreator();
        csvCreator.exportReport("Monthly Sales Report");
        System.out.println();

        ReportExporterCreator jsonCreator = new JsonReportExporterCreator();
        jsonCreator.exportReport("Monthly Sales Report");
        System.out.println();

        ReportExporterCreator xmlCreator = new XmlReportExporterCreator();
        xmlCreator.exportReport("Monthly Sales Report");
    }
}