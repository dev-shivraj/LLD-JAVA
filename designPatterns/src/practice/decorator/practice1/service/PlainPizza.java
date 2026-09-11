package practice.decorator.practice1.service;

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