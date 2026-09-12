package practice.decorator.part2.example1.decorator;

import practice.decorator.part2.example1.component.Beverage;

public class MochaDecorator extends BeverageDecorator {

    public MochaDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 30;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}