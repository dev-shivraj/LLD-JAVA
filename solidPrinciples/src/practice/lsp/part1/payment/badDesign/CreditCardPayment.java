package practice.lsp.part1.payment.badDesign;

public class CreditCardPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Credit card payment made");
    }

    @Override
    public void refund() {
        System.out.println("Credit card payment refunded");
    }
}