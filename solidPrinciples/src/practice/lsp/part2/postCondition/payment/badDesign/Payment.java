package practice.lsp.part2.postCondition.payment.badDesign;

public class Payment {
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        System.out.println("Payment processed");
        return true;
    }
}