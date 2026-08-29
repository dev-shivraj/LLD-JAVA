package practice.isp.part2.bird.goodDesign;

public class Sparrow implements Bird, Flyable, Singable {
    @Override
    public void eat() {
        System.out.println("Sparrow is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Sparrow is sleeping");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }

    @Override
    public void sing() {
        System.out.println("Sparrow is singing");
    }
}