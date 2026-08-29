package practice.isp.part3.printer.goodDesign;

public class PrinterClient {
    public static void main(String[] args) {
        Printable printer = new SimplePrinter();
        printer.print();
        System.out.println("----------------");

        Printable multiFunctionPrinter = new MultiFunctionPrinter();
        multiFunctionPrinter.print();
        System.out.println("----------------");

        Scannable scanner = new MultiFunctionPrinter();
        scanner.scan();
        System.out.println("----------------");

        Faxable faxMachine = new MultiFunctionPrinter();
        faxMachine.fax();
        System.out.println("----------------");

        Copyable copier = new MultiFunctionPrinter();
        copier.copy();
    }
}