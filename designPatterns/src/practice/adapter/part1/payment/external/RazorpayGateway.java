package practice.adapter.part1.payment.external;

public class RazorpayGateway {
    public void makePayment(double amount) {
        System.out.println("Razorpay payment processed: ₹" + amount);
    }
}
