package practice.ocp.part1.printer.goodDesign;

public class ImageDocument implements PrintableDocument{
    @Override
    public void print() {
        System.out.println("Printing Image Document");
    }
}
