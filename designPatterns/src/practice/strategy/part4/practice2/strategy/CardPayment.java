package practice.strategy.part4.practice2.strategy;

public class CardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using CARD");
    }
}