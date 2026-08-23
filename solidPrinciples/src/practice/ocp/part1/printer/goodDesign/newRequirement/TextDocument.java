package practice.ocp.part1.printer.goodDesign.newRequirement;

import practice.ocp.part1.printer.goodDesign.PrintableDocument;

public class TextDocument implements PrintableDocument {
    @Override
    public void print() {
        System.out.println("Printing Text Document");
    }
}
