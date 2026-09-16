package practice.strategy.part1.practice1.strategy;

public class StandardShippingStrategy implements ShippingStrategy {

    @Override
    public double calculateCost() {
        return 50;
    }
}