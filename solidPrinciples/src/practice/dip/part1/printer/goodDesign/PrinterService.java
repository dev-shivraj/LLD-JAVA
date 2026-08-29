package practice.dip.part1.printer.goodDesign;

public class PrinterService {
    private final Printer printer;

    public PrinterService(Printer printer) {
        this.printer = printer;
    }

    public void printDocument() {
        printer.print();
    }
}