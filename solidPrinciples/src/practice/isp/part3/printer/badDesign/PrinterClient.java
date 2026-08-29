package practice.isp.part3.printer.badDesign;

public class PrinterClient {
    public static void main(String[] args) {
        Printer printer = new SimplePrinter();
        printer.print();
        printer.scan();
        printer.fax();
        printer.copy();
    }
}