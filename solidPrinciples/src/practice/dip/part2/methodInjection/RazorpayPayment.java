package practice.dip.part2.methodInjection;

public class RazorpayPayment implements PaymentGateway {
    @Override
    public void pay() {
        System.out.println("Payment processed using Razorpay");
    }
}