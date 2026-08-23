package practice.ocp.part4.printer.goodDesign.newRequirement;

import practice.ocp.part4.printer.goodDesign.PrintableDocument;

public class ExcelDocument implements PrintableDocument {

    @Override
    public void print() {
        System.out.println("Printing Excel");
    }
}