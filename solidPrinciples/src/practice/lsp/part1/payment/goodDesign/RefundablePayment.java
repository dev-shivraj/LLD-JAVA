package practice.lsp.part1.payment.goodDesign;

public class RefundablePayment extends Payment {
    public void refund() {
        System.out.println("Payment refunded");
    }
}