package practice.strategy.part4.example1.strategy.discount;

public class PremiumDiscount implements DiscountStrategy {

    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.10;
    }
}