package practice.isp.part1.bird.goodDesign;


public class Sparrow implements Bird, Flyable {
    @Override
    public void eat() {
        System.out.println("Bird is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Bird is sleeping");
    }

    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }
}
