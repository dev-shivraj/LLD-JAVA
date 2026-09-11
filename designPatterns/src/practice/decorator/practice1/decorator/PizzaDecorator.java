package practice.decorator.practice1.decorator;

import practice.decorator.practice1.service.Pizza;

public abstract class PizzaDecorator implements Pizza {

    protected Pizza pizza;

    protected PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getPrice() {
        return pizza.getPrice();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }
}