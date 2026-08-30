package practice.lsp.part1.payment.badDesign;

public class CashPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Cash payment made");
    }

    @Override
    public void refund() {
        throw new UnsupportedOperationException("Cash payment cannot be refunded");
    }
}