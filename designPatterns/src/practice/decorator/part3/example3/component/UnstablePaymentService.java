package practice.decorator.part3.example3.component;

public class UnstablePaymentService implements PaymentService {

    private int attempts;

    @Override
    public void pay(double amount) {
        attempts++;

        System.out.println("Payment attempt: " + attempts);

        if (attempts < 3) {
            throw new RuntimeException("Payment failed");
        }

        System.out.println("Payment successful: ₹" + amount);
    }
}