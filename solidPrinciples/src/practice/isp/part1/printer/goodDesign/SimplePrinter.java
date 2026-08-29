package practice.isp.part1.printer.goodDesign;

public class SimplePrinter implements Printable {

    @Override
    public void print() {
        System.out.println("Printing Document");
    }
}
