package practice.decorator.example1;

import practice.decorator.example1.decorator.MilkDecorator;
import practice.decorator.example1.decorator.SugarDecorator;
import practice.decorator.example1.service.Coffee;
import practice.decorator.example1.service.SimpleCoffee;

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