package practice.decorator.example1.service;

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