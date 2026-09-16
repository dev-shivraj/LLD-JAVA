package practice.strategy.part3.example1;

import practice.strategy.part3.example1.service.Order;
import practice.strategy.part3.example1.strategy.PremiumDiscount;
import practice.strategy.part3.example1.strategy.RegularDiscount;
import practice.strategy.part3.example1.strategy.VipDiscount;

public class Main {

    public static void main(String[] args) {

        Order regularOrder = new Order(new RegularDiscount());
        Order premiumOrder = new Order(new PremiumDiscount());
        Order vipOrder = new Order(new VipDiscount());

        System.out.println(regularOrder.calculateFinalPrice(1000));
        System.out.println(premiumOrder.calculateFinalPrice(1000));
        System.out.println(vipOrder.calculateFinalPrice(1000));
    }
}