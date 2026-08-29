package practice.dip.part3.printer.goodDesign;

public class PrinterClient {
    public static void main(String[] args) {
        PrinterLogger logger = new ConsolePrinterLogger();
        Printer printer = new HPPrinter();
        PrinterService service = new PrinterService(printer, logger);

        service.printDocument();
        System.out.println("----------------");
        printer = new CanonPrinter();
        service = new PrinterService(printer, logger);
        service.printDocument();
    }
}