package practice.lsp.part2.invariants.printer.goodDesign;

public class Printer {
    protected int inkLevel = 100;

    public void print() {
        if (inkLevel < 10) {
            throw new IllegalStateException("Not enough ink");
        }

        inkLevel -= 10;
        System.out.println("Printing");
    }

    public int getInkLevel() {
        return inkLevel;
    }
}