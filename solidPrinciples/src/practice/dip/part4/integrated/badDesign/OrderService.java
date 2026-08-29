package practice.dip.part4.integrated.badDesign;

public class OrderService {
    private final StripePayment payment = new StripePayment();
    private final MySQLOrderRepository repository = new MySQLOrderRepository();
    private final EmailNotification notification = new EmailNotification();
    private final InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    public void processOrder(String orderId, double amount) {
        payment.pay(amount);
        repository.save(orderId);
        invoiceGenerator.generate(orderId, amount);
        notification.send("Order " + orderId + " processed");
    }
}