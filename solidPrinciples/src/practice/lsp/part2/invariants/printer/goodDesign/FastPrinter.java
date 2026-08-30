package practice.lsp.part2.invariants.printer.goodDesign;

public class FastPrinter extends Printer {
    @Override
    public void print() {
        if (inkLevel < 10) {
            throw new IllegalStateException("Not enough ink");
        }

        inkLevel -= 10;
        System.out.println("Fast printing");
    }
}