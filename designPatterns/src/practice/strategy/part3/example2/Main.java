package practice.strategy.part3.example2;

import practice.strategy.part3.example2.service.Order;
import practice.strategy.part3.example2.strategy.DiscountStrategy;

public class Main {

    public static void main(String[] args) {

        DiscountStrategy regular = amount -> amount * 0.05;
        DiscountStrategy premium = amount -> amount * 0.10;

        Order regularOrder = new Order(regular);
        Order premiumOrder = new Order(premium);

        System.out.println(regularOrder.calculateFinalPrice(1000));
        System.out.println(premiumOrder.calculateFinalPrice(1000));
    }
}