package practice.strategy.part3.example1.strategy;

public class RegularDiscount implements DiscountStrategy {

    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.05;
    }
}