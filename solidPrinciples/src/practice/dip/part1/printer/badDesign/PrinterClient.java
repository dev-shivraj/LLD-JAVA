package practice.dip.part1.printer.badDesign;

public class PrinterClient {

    public static void main(String[] args) {

        PrinterService service =
                new PrinterService();

        service.printDocument();
    }
}