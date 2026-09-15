package practice.decorator.base.component;

public class Decaf implements Coffee {
    @Override
    public int cost() {
        return 120;
    }

    @Override
    public String description() {
        return "Decaf";
    }
}