package practice.factory.part3.registryfactory.payment.component;

public class PayPalPayment implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal");
    }
}
