package practice.strategy.part2.practice2.factory;

import practice.strategy.part2.practice2.strategy.ExpressShippingStrategy;
import practice.strategy.part2.practice2.strategy.SameDayShippingStrategy;
import practice.strategy.part2.practice2.strategy.ShippingStrategy;
import practice.strategy.part2.practice2.strategy.StandardShippingStrategy;

public class ShippingStrategyFactory {

    public static ShippingStrategy getStrategy(String shippingType) {
        return switch (shippingType.toUpperCase()) {
            case "STANDARD" -> new StandardShippingStrategy();
            case "EXPRESS" -> new ExpressShippingStrategy();
            case "SAME_DAY" -> new SameDayShippingStrategy();
            default -> throw new IllegalArgumentException("Unsupported shipping type: " + shippingType);
        };
    }
}