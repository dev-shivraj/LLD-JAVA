package practice.decorator.practice1;

import practice.decorator.practice1.decorator.CheeseDecorator;
import practice.decorator.practice1.decorator.MushroomDecorator;
import practice.decorator.practice1.decorator.OliveDecorator;
import practice.decorator.practice1.service.Pizza;
import practice.decorator.practice1.service.PlainPizza;

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