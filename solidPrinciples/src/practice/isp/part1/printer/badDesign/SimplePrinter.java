package practice.isp.part1.printer.badDesign;

public class SimplePrinter implements Printer{

    @Override
    public void print() {
        System.out.println("Printing Document");
    }

    @Override
    public void scan() {
        System.out.println("Simple printer can not scan");
    }

    @Override
    public void fax() {
        System.out.println("Simple printer can not fax");
    }
}
