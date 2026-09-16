package practice.strategy.part2.practice2;

import practice.strategy.part2.practice2.factory.ShippingStrategyFactory;
import practice.strategy.part2.practice2.service.ShippingService;
import practice.strategy.part2.practice2.strategy.ShippingStrategy;

public class Client {

    public static void main(String[] args) {

        ShippingStrategy strategy = ShippingStrategyFactory.getStrategy("EXPRESS");
        ShippingService service = new ShippingService(strategy);
        System.out.println(service.calculateShippingCost());
    }
}