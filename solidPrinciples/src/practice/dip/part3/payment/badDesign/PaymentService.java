package practice.dip.part3.payment.badDesign;

public class PaymentService {

    private final StripePayment payment =
            new StripePayment();

    private final TaxCalculator taxCalculator =
            new TaxCalculator();

    private final EmailNotification notification =
            new EmailNotification();

    public void processPayment(double amount) {

        double tax =
                taxCalculator.calculateTax(amount);

        double finalAmount =
                amount + tax;

        payment.pay(finalAmount);

        notification.send(
                "Payment completed"
        );
    }
}