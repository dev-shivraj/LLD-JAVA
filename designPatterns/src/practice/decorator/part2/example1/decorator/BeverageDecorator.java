package practice.decorator.part2.example1.decorator;

import practice.decorator.part2.example1.component.Beverage;

public abstract class BeverageDecorator implements Beverage {

    protected Beverage beverage;

    protected BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double getCost() {
        return beverage.getCost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }
}