package practice.decorator.example1.decorator;

import practice.decorator.example1.service.Coffee;

public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 10;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }
}