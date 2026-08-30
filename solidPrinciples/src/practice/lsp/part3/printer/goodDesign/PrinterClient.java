package practice.lsp.part3.printer.goodDesign;

public class PrinterClient {
    public static void main(String[] args) {
        Printer basicPrinter = new BasicPrinter();
        basicPrinter.print();
        System.out.println("----------------");

        MultiFunctionPrinter printer = new MultiFunctionPrinter();
        printer.print();
        printer.scan();
    }
}