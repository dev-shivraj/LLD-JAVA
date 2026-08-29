package practice.isp.part1.printer.goodDesign;

public class AdvancePrinter implements Printable, Scanable, Faxable {

    @Override
    public void print() {
        System.out.println("Printing Document");
    }

    @Override
    public void scan() {
        System.out.println("Scanning Document");
    }

    @Override
    public void fax() {
        System.out.println("Faxing Document");
    }
}
