package practice.dip.part4.integrated.goodDesign;

public class RazorpayPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Payment processed using Razorpay: " + amount);
    }
}