package practice.decorator.part1.practice1.decorator;

import practice.decorator.part1.practice1.service.Pizza;

public class CheeseDecorator extends PizzaDecorator {

    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 30;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }
}