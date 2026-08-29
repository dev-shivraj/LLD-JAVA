package practice.dip.part3.printer.goodDesign;

public class PrinterService {
    private final Printer printer;
    private final PrinterLogger logger;

    public PrinterService(Printer printer, PrinterLogger logger) {
        this.printer = printer;
        this.logger = logger;
    }

    public void printDocument() {
        printer.print();
        logger.log("Document printed");
    }
}