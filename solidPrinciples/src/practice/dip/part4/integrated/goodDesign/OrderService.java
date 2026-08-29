package practice.dip.part4.integrated.goodDesign;

public class OrderService {
    private final PaymentGateway paymentGateway;
    private final OrderRepository orderRepository;
    private final Notification notification;
    private final InvoiceGenerator invoiceGenerator;

    public OrderService(PaymentGateway paymentGateway, OrderRepository orderRepository, Notification notification, InvoiceGenerator invoiceGenerator) {
        this.paymentGateway = paymentGateway;
        this.orderRepository = orderRepository;
        this.notification = notification;
        this.invoiceGenerator = invoiceGenerator;
    }

    public void processOrder(String orderId, double amount) {
        paymentGateway.pay(amount);
        orderRepository.save(orderId);
        invoiceGenerator.generate(orderId, amount);
        notification.send("Order " + orderId + " processed");
    }
}