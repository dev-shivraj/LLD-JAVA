package practice.ocp.part4.printer.goodDesign;

public class PdfDocument implements PrintableDocument {

    @Override
    public void print() {
        System.out.println("Printing PDF");
    }
}