package practice.strategy.part2.example5.strategy.discount;

public class PremiumDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.10;
    }
}