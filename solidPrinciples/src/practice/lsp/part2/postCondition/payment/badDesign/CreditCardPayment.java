package practice.lsp.part2.postCondition.payment.badDesign;

public class CreditCardPayment extends Payment {
    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        System.out.println("Credit card payment processed");
        return false;
    }
}