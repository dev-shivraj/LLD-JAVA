package practice.decorator.example1.decorator;

import practice.decorator.example1.service.Coffee;

public abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;

    protected CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }
}