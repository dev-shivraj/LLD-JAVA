package practice.lsp.part3.payment.goodDesign;

public class CreditCardPayment implements Payment, Refundable {
    @Override
    public void process() {
        System.out.println("Credit card payment processed");
    }

    @Override
    public void refund() {
        System.out.println("Credit card payment refunded");
    }
}