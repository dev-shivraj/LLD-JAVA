package practice.dip.part3.printer.goodDesign;

public class ConsolePrinterLogger implements PrinterLogger {
    @Override
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}