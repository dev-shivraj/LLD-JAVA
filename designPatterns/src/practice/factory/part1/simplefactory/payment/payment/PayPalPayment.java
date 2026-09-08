package practice.factory.part1.simplefactory.payment.payment;

public class PayPalPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal");
    }
}