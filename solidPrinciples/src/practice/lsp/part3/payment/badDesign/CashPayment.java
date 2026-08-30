package practice.lsp.part3.payment.badDesign;

public class CashPayment extends Payment {
    @Override
    public void refund() {
        throw new UnsupportedOperationException("Cash payment does not support automatic refund");
    }
}