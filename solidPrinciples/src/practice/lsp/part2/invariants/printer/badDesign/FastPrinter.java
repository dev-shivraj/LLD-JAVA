package practice.lsp.part2.invariants.printer.badDesign;

public class FastPrinter extends Printer {
    @Override
    public void print() {
        inkLevel -= 150;
        System.out.println("Fast printing");
    }
}