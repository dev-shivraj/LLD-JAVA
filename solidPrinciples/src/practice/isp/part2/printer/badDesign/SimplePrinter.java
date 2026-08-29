package practice.isp.part2.printer.badDesign;

public class SimplePrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Printing");
    }

    @Override
    public void scan() {
        System.out.println("Scan not supported");
    }

    @Override
    public void fax() {
        System.out.println("Fax not supported");
    }

    @Override
    public void copy() {
        System.out.println("Copy not supported");
    }
}