package practice.decorator.part2.example1.decorator;

import practice.decorator.part2.example1.component.Beverage;

public class WhipDecorator extends BeverageDecorator {

    public WhipDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 25;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whipped Cream";
    }
}