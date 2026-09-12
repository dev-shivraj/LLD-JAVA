package practice.decorator.part2.practice1.component;

public class BasicPaymentProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Final payment amount: ₹" + amount);
    }
}