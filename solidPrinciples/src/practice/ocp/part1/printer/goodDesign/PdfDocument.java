package practice.ocp.part1.printer.goodDesign;

public class PdfDocument implements PrintableDocument{
    @Override
    public void print() {
        System.out.println("Printing PDF");
    }
}
