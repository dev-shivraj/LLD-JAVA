package practice.dip.part1.printer.goodDesign;

public class PrinterClient {
    public static void main(String[] args) {
        Printer printer = new HPPrinter();
        PrinterService service = new PrinterService(printer);
        service.printDocument();
        System.out.println("----------------");

        printer = new CanonPrinter();
        service = new PrinterService(printer);
        service.printDocument();
    }
}