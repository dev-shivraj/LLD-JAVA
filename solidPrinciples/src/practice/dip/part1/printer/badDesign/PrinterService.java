package practice.dip.part1.printer.badDesign;

public class PrinterService {

    private final HPPrinter printer =
            new HPPrinter();

    public void printDocument() {
        printer.print();
    }
}