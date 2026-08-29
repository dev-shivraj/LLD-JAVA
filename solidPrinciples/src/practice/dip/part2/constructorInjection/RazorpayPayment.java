package practice.dip.part2.constructorInjection;

public class RazorpayPayment implements PaymentGateway {
    @Override
    public void pay() {
        System.out.println("Payment processed using Razorpay");
    }
}