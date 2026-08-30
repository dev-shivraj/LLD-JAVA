package practice.lsp.part3.printer.goodDesign;

public class BasicPrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Printing");
    }
}