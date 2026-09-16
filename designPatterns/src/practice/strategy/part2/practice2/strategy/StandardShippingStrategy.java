package practice.strategy.part2.practice2.strategy;

public class StandardShippingStrategy implements ShippingStrategy {

    @Override
    public double calculateCost() {
        return 50;
    }
}