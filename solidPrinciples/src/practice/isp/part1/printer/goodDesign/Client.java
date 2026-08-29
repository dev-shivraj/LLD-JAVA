package practice.isp.part1.printer.goodDesign;

public class Client {
    public static void main(String[] args) {
        SimplePrinter simplePrinter = new SimplePrinter();
        simplePrinter.print();


        AdvancePrinter advancePrinter = new AdvancePrinter();

        System.out.println();
        advancePrinter.print();
        advancePrinter.fax();
        advancePrinter.scan();
    }
}
