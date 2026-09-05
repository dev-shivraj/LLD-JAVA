package practice.facade.part2.ecommerce.services;

public class PaymentService {
    public void pay(String paymentId, double amount) {
        System.out.println("Processing payment " + paymentId + ": " + amount);

        if("FAIL".equals(paymentId)) {
            throw new RuntimeException("Payment failed");
        }

        System.out.println("Payment successful");
    }
}
