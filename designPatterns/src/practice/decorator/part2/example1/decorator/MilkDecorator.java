package practice.decorator.part2.example1.decorator;

import practice.decorator.part2.example1.component.Beverage;

public class MilkDecorator extends BeverageDecorator {

    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 20;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }
}