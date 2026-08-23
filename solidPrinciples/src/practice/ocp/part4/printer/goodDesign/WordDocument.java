package practice.ocp.part4.printer.goodDesign;

public class WordDocument implements PrintableDocument {

    @Override
    public void print() {
        System.out.println("Printing Word");
    }
}