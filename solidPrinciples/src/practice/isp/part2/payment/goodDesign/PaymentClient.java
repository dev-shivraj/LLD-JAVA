package practice.isp.part2.payment.goodDesign;

public class PaymentClient {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new CreditCardPayment();
        paymentProcessor.pay();
        System.out.println("----------------");

        Refundable refundable = new CreditCardPayment();
        refundable.refund();
        System.out.println("----------------");

        ReceiptGenerator receiptGenerator = new CreditCardPayment();
        receiptGenerator.generateReceipt();
        System.out.println("----------------");

        NotificationSender notificationSender = new CreditCardPayment();
        notificationSender.sendNotification();
        System.out.println("----------------");

        CashPayable cashPayable = new CashPayment();
        cashPayable.payWithCash();
    }
}