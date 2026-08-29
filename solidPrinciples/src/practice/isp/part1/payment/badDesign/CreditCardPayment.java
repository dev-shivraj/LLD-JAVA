package practice.isp.part1.payment.badDesign;

public class CreditCardPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("Payment is being processed");
    }

    @Override
    public void refund() {
        System.out.println("Refund is being processed");
    }

    @Override
    public void payWithCash() {
        System.out.println("Credit card doesn't support Cash");
    }
}
