package practice.isp.part3.printer.goodDesign;

public class MultiFunctionPrinter implements Printable, Scannable, Faxable, Copyable {
    @Override
    public void print() {
        System.out.println("Printing");
    }

    @Override
    public void scan() {
        System.out.println("Scanning");
    }

    @Override
    public void fax() {
        System.out.println("Faxing");
    }

    @Override
    public void copy() {
        System.out.println("Copying");
    }
}