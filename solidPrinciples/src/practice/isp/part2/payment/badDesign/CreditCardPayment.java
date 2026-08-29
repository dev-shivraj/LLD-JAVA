package practice.isp.part2.payment.badDesign;

public class CreditCardPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Credit card payment");
    }

    @Override
    public void refund() {
        System.out.println("Credit card refund");
    }

    @Override
    public void payWithCash() {
        System.out.println("Not supported");
    }

    @Override
    public void generateReceipt() {
        System.out.println("Generating receipt");
    }

    @Override
    public void sendNotification() {
        System.out.println("Sending notification");
    }
}