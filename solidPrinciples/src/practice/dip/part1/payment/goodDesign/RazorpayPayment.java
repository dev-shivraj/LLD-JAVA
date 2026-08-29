package practice.dip.part1.payment.goodDesign;

public class RazorpayPayment implements PaymentGateway {
    @Override
    public void pay() {
        System.out.println("Payment processed using Razorpay");
    }
}