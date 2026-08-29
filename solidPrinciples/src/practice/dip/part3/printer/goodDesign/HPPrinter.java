package practice.dip.part3.printer.goodDesign;

public class HPPrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Printing using HP printer");
    }
}