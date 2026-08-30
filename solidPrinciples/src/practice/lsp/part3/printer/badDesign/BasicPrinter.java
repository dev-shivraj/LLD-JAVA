package practice.lsp.part3.printer.badDesign;

public class BasicPrinter extends Printer {
    @Override
    public void scan() {
        throw new UnsupportedOperationException("Basic printer cannot scan");
    }
}