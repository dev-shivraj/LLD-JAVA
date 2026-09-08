package practice.factory.part3.example2.processor;

public class CreditCardPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card payment: " + amount);
    }
}