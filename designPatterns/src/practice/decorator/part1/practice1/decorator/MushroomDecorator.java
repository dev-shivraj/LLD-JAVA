package practice.decorator.part1.practice1.decorator;

import practice.decorator.part1.practice1.service.Pizza;

public class MushroomDecorator extends PizzaDecorator {

    public MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 25;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushrooms";
    }
}