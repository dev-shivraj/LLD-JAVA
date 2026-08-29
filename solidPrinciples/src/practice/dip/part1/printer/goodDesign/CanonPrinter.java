package practice.dip.part1.printer.goodDesign;

public class CanonPrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Printing using Canon printer");
    }
}