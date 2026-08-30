package practice.lsp.part1.payment.goodDesign;

public class CashPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Cash payment made");
    }
}