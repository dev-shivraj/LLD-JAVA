package practice.decorator.part2.example1.component;

public class Espresso implements Beverage {

    @Override
    public double getCost() {
        return 100;
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }
}