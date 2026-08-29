package practice.isp.part3.printer.goodDesign;

public class SimplePrinter implements Printable {
    @Override
    public void print() {
        System.out.println("Printing");
    }
}