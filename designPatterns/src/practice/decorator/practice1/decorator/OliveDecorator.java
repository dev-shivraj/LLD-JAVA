package practice.decorator.practice1.decorator;

import practice.decorator.practice1.service.Pizza;

public class OliveDecorator extends PizzaDecorator {

    public OliveDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 20;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }
}