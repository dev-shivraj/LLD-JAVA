package practice.dip.part3.printer.badDesign;

public class PrinterClient {
    public static void main(String[] args) {
        PrinterService service = new PrinterService();
        service.printDocument();
    }
}