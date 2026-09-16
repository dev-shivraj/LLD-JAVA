package practice.strategy.part1.example3.strategy;

public class RegularDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateDiscount(double price) {
        return price * 0.05;
    }
}