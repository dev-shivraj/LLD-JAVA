package practice.isp.part2.payment.goodDesign;

public class CreditCardPayment implements PaymentProcessor, Refundable, ReceiptGenerator, NotificationSender {
    @Override
    public void pay() {
        System.out.println("Credit card payment");
    }

    @Override
    public void refund() {
        System.out.println("Credit card refund");
    }

    @Override
    public void generateReceipt() {
        System.out.println("Generating credit card receipt");
    }

    @Override
    public void sendNotification() {
        System.out.println("Sending notification");
    }
}