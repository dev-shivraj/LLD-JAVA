package practice.dip.part3.printer.badDesign;

public class PrinterService {
    private final HPPrinter printer = new HPPrinter();
    private final PrinterLogger logger = new PrinterLogger();

    public void printDocument() {
        printer.print();
        logger.log("Document printed");
    }
}