package practice.strategy.part1.practice1.strategy;

public class ExpressShippingStrategy implements ShippingStrategy {

    @Override
    public double calculateCost() {
        return 100;
    }
}