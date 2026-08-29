package practice.isp.part2.payment.goodDesign;

public class CashPayment implements PaymentProcessor, CashPayable, ReceiptGenerator {
    @Override
    public void pay() {
        System.out.println("Cash payment");
    }

    @Override
    public void payWithCash() {
        System.out.println("Paying with cash");
    }

    @Override
    public void generateReceipt() {
        System.out.println("Generating cash receipt");
    }
}