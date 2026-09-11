package practice.decorator.part1.practice1.component;

public class PlainPizza implements Pizza {

    @Override
    public double getPrice() {
        return 100;
    }

    @Override
    public String getDescription() {
        return "Plain Pizza";
    }
}