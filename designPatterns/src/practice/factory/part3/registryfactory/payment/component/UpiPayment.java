package practice.factory.part3.registryfactory.payment.component;

public class UpiPayment implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}
