package practice.strategy.part4.example1.strategy.discount;

public class RegularDiscount implements DiscountStrategy {

    @Override
    public double calculateDiscount(double amount) {
        return 0;
    }
}