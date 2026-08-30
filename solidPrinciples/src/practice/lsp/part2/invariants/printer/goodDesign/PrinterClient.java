package practice.lsp.part2.invariants.printer.goodDesign;

public class PrinterClient {
    public static void main(String[] args) {
        Printer printer = new FastPrinter();
        printer.print();
        System.out.println("Ink level: " + printer.getInkLevel());
    }
}