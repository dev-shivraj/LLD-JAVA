package practice.factory.part1.simplefactory.document.component;

public class PdfDocument implements Document{
    @Override
    public void export() {
        System.out.println("Exporting document as PDF");
    }
}
