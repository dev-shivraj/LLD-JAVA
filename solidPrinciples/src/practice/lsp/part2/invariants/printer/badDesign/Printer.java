package practice.lsp.part2.invariants.printer.badDesign;

public class Printer {
    protected int inkLevel = 100;

    public void print() {
        if (inkLevel <= 0) {
            throw new IllegalStateException("No ink available");
        }

        inkLevel -= 10;
        System.out.println("Printing");
    }

    public int getInkLevel() {
        return inkLevel;
    }
}