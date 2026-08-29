package practice.isp.part3.printer.badDesign;

public class SimplePrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Printing");
    }

    @Override
    public void scan() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void fax() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void copy() {
        throw new UnsupportedOperationException();
    }
}