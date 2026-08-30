package practice.lsp.part3.printer.badDesign;

public class PrinterClient {
    public static void main(String[] args) {
        Printer printer = new BasicPrinter();
        printer.print();
        printer.scan();
    }
}