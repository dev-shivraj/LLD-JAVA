package practice.strategy.part2.example5.strategy.shipping;

public class ExpressShippingStrategy implements ShippingStrategy {

    @Override
    public double calculateCost() {
        return 100;
    }
}