package practice.decorator.part1.example1.component;

public class SimpleCoffee implements Coffee {

    @Override
    public double getCost() {
        return 50;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}