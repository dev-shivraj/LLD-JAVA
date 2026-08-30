package practice.lsp.part1.payment.goodDesign;

public class CreditCardPayment extends RefundablePayment {
    @Override
    public void pay() {
        System.out.println("Credit card payment made");
    }

    @Override
    public void refund() {
        System.out.println("Credit card payment refunded");
    }
}