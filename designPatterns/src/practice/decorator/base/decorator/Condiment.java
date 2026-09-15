package practice.decorator.base.decorator;

import practice.decorator.base.component.Coffee;

public abstract class Condiment implements Coffee {

    protected Coffee coffee;

    public Condiment(Coffee coffee) {
        this.coffee = coffee;
    }

    public abstract int cost();

    public abstract String description();
}