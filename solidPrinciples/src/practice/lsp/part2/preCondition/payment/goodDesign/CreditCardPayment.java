package practice.lsp.part2.preCondition.payment.goodDesign;

public class CreditCardPayment extends Payment {
    @Override
    public void processPayment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        System.out.println("Credit card payment processed");
    }
}