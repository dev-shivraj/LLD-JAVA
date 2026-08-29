package practice.isp.part1.printer.badDesign;

public class Client {
    public static void main(String[] args) {
        SimplePrinter simplePrinter = new SimplePrinter();
        simplePrinter.print();
        simplePrinter.fax();
        simplePrinter.scan();
    }
}
