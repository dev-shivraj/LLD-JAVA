package practice.strategy.part3.practice1;

import practice.strategy.part3.practice1.service.ShippingService;
import practice.strategy.part3.practice1.strategy.ExpressShipping;
import practice.strategy.part3.practice1.strategy.SameDayShipping;
import practice.strategy.part3.practice1.strategy.StandardShipping;

public class Main {

    public static void main(String[] args) {

        ShippingService standard = new ShippingService(new StandardShipping());
        ShippingService express = new ShippingService(new ExpressShipping());
        ShippingService sameDay = new ShippingService(new SameDayShipping());

        System.out.println(standard.calculateShipping(10));
        System.out.println(express.calculateShipping(10));
        System.out.println(sameDay.calculateShipping(10));
    }
}