package practice.isp.part1.bird.badDesign;

public class Penguin implements Bird{
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
        System.out.println("Penguin can't fly");
    }

    @Override
    public void swim() {
        System.out.println("Bird is swimming");
    }
}
