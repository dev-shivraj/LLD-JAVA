package practice.decorator.base.decorator;

import practice.decorator.base.component.Coffee;

public class Moka extends Condiment {
    public Moka(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int cost() {
        return coffee.cost()+50;
    }

    @Override
    public String description() {
        return coffee.description()+"Moka";
    }
}