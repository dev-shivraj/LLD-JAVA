package practice.isp.part2.bird.badDesign;

public class Sparrow implements Bird {
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
    public void swim() {
        System.out.println("Sparrow does not swim");
    }

    @Override
    public void sing() {
        System.out.println("Sparrow does not sing");
    }
}