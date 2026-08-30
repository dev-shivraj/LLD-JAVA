package practice.lsp.part2.preCondition.printer.badDesign;

public class ColorPrinter extends Printer {
    @Override
    public void print(String document) {
        if (document == null || !document.endsWith(".pdf")) {
            throw new IllegalArgumentException("Color printer accepts only PDF");
        }

        System.out.println("Printing color document");
    }
}