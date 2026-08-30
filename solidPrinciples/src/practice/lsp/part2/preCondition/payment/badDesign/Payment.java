package practice.lsp.part2.preCondition.payment.badDesign;

public class Payment {
    public void processPayment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        System.out.println("Payment processed");
    }
}