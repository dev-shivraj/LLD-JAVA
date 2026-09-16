package practice.strategy.part1.practice1.strategy;

public class SameDayShippingStrategy implements ShippingStrategy {

    @Override
    public double calculateCost() {
        return 200;
    }
}