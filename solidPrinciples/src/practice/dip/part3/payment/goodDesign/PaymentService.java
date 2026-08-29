package practice.dip.part3.payment.goodDesign;

public class PaymentService {

    private final PaymentGateway paymentGateway;
    private final TaxCalculator taxCalculator;
    private final Notification notification;

    public PaymentService(
            PaymentGateway paymentGateway,
            TaxCalculator taxCalculator,
            Notification notification) {

        this.paymentGateway = paymentGateway;
        this.taxCalculator = taxCalculator;
        this.notification = notification;
    }

    public void processPayment(double amount) {

        double tax =
                taxCalculator.calculateTax(amount);

        double finalAmount =
                amount + tax;

        paymentGateway.pay(finalAmount);

        notification.send(
                "Payment completed"
        );
    }
}