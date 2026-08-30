package practice.lsp.part2.preCondition.printer.badDesign;

public class PrinterClient {
    public static void main(String[] args) {
        Printer printer = new ColorPrinter();
        printer.print("document.txt");
    }
}