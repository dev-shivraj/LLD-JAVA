package practice.decorator.part1.practice1;

import practice.decorator.part1.practice1.decorator.CheeseDecorator;
import practice.decorator.part1.practice1.decorator.MushroomDecorator;
import practice.decorator.part1.practice1.decorator.OliveDecorator;
import practice.decorator.part1.practice1.service.Pizza;
import practice.decorator.part1.practice1.service.PlainPizza;

public class Client {

    public static void main(String[] args) {

        Pizza pizza = new PlainPizza();

        pizza = new CheeseDecorator(pizza);
        pizza = new OliveDecorator(pizza);
        pizza = new MushroomDecorator(pizza);

        System.out.println("Pizza: " + pizza.getDescription());
        System.out.println("Price: ₹" + pizza.getPrice());
    }
}