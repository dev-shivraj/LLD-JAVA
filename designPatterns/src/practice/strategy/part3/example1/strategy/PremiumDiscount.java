package practice.strategy.part3.example1.strategy;

public class PremiumDiscount implements DiscountStrategy {

    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.10;
    }
}