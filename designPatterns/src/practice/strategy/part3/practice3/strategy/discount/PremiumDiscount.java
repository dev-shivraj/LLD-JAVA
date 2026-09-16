package practice.strategy.part3.practice3.strategy.discount;

public class PremiumDiscount implements DiscountStrategy {

    @Override
    public double calculateDiscount(double price) {
        return price * 0.10;
    }
}