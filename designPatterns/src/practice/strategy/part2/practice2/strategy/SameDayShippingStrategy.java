package practice.strategy.part2.practice2.strategy;

public class SameDayShippingStrategy implements ShippingStrategy {

    @Override
    public double calculateCost() {
        return 200;
    }
}