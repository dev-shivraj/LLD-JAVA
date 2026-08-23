package practice.ocp.part1.printer.goodDesign;

import practice.ocp.part1.printer.goodDesign.newRequirement.ExcelDocument;
import practice.ocp.part1.printer.goodDesign.newRequirement.PowerpointDocument;
import practice.ocp.part1.printer.goodDesign.newRequirement.TextDocument;

public class DocumentClient {
    public static void main(String[] args) {
        // existing design
        PrintableDocument pdfDocument = new PdfDocument();
        PrintableDocument wordDocument = new WordDocument();
        PrintableDocument imageDocument = new ImageDocument();

        // new requirement
        PrintableDocument excelDocument = new ExcelDocument();
        PrintableDocument powerpointDocument = new PowerpointDocument();
        PrintableDocument textDocument = new TextDocument();




        pdfDocument.print();
        wordDocument.print();
        imageDocument.print();

        // new requirement
        excelDocument.print();
        powerpointDocument.print();
        textDocument.print();
    }
}
