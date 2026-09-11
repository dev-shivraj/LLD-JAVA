package practice.decorator.part1.example1;

import practice.decorator.part1.example1.decorator.MilkDecorator;
import practice.decorator.part1.example1.decorator.SugarDecorator;
import practice.decorator.part1.example1.component.Coffee;
import practice.decorator.part1.example1.component.SimpleCoffee;

public class Client {

    public static void main(String[] args) {

        Coffee coffee = new SimpleCoffee();

        System.out.println(coffee.getDescription());
        System.out.println("Cost: " + coffee.getCost());

        coffee = new MilkDecorator(coffee);

        System.out.println(coffee.getDescription());
        System.out.println("Cost: " + coffee.getCost());

        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription());
        System.out.println("Cost: " + coffee.getCost());
    }
}