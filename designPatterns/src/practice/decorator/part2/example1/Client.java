package practice.decorator.part2.example1;

import practice.decorator.part2.example1.component.Beverage;
import practice.decorator.part2.example1.component.Espresso;
import practice.decorator.part2.example1.decorator.MilkDecorator;
import practice.decorator.part2.example1.decorator.MochaDecorator;
import practice.decorator.part2.example1.decorator.WhipDecorator;

public class Client {

    public static void main(String[] args) {

        Beverage beverage = new Espresso();

        beverage = new MilkDecorator(beverage);
        beverage = new MochaDecorator(beverage);
        beverage = new WhipDecorator(beverage);

        System.out.println("Order: " + beverage.getDescription());
        System.out.println("Total: ₹" + beverage.getCost());
    }
}