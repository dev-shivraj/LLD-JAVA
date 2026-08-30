package practice.lsp.part2.preCondition.payment.badDesign;

public class CreditCardPayment extends Payment {
    @Override
    public void processPayment(double amount) {
        if (amount < 500) {
            throw new IllegalArgumentException("Credit card payment must be at least 500");
        }

        System.out.println("Credit card payment processed");
    }
}