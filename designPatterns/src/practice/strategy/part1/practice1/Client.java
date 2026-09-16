package practice.strategy.part1.practice1;

import practice.strategy.part1.practice1.service.ShippingService;
import practice.strategy.part1.practice1.strategy.ExpressShippingStrategy;
import practice.strategy.part1.practice1.strategy.SameDayShippingStrategy;
import practice.strategy.part1.practice1.strategy.StandardShippingStrategy;

public class Client {

    public static void main(String[] args) {

        ShippingService standardShipping = new ShippingService(new StandardShippingStrategy());
        System.out.println("Standard shipping: ₹" + standardShipping.calculateShippingCost());


        ShippingService expressShipping = new ShippingService(new ExpressShippingStrategy());
        System.out.println("Express shipping: ₹" + expressShipping.calculateShippingCost());


        ShippingService sameDayShipping = new ShippingService(new SameDayShippingStrategy());
        System.out.println("Same-day shipping: ₹" + sameDayShipping.calculateShippingCost());
    }
}