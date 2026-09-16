package practice.strategy.part2.practice2.strategy;

public class ExpressShippingStrategy implements ShippingStrategy {

    @Override
    public double calculateCost() {
        return 100;
    }
}