package practice.isp.part1.payment.goodDesign;

public class CreditCardPayment implements Payment, Refundable {
    @Override
    public void pay() {
        System.out.println("Payment is being processed");
    }

    @Override
    public void refund() {
        System.out.println("Refund is being processed");
    }
}
