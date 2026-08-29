package practice.dip.part4.integrated.goodDesign;

public class OrderClient {
    public static void main(String[] args) {
        PaymentGateway paymentGateway = new StripePayment();
        OrderRepository orderRepository = new MySQLOrderRepository();
        Notification notification = new EmailNotification();
        InvoiceGenerator invoiceGenerator = new PDFInvoiceGenerator();
        OrderService orderService = new OrderService(paymentGateway, orderRepository, notification, invoiceGenerator);

        orderService.processOrder("ORD-101", 5000);
    }
}