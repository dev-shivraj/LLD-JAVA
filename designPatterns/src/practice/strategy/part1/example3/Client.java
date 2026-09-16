package practice.strategy.part1.example3;

import practice.strategy.part1.example3.service.PriceCalculator;
import practice.strategy.part1.example3.strategy.PremiumDiscountStrategy;
import practice.strategy.part1.example3.strategy.RegularDiscountStrategy;
import practice.strategy.part1.example3.strategy.VipDiscountStrategy;

public class Client {

    public static void main(String[] args) {

        PriceCalculator regularCustomer = new PriceCalculator(new RegularDiscountStrategy());
        System.out.println("Regular customer: ₹" + regularCustomer.calculateFinalPrice(1000));


        PriceCalculator premiumCustomer = new PriceCalculator(new PremiumDiscountStrategy());
        System.out.println("Premium customer: ₹" + premiumCustomer.calculateFinalPrice(1000));


        PriceCalculator vipCustomer = new PriceCalculator(new VipDiscountStrategy());
        System.out.println("VIP customer: ₹" + vipCustomer.calculateFinalPrice(1000));
    }
}