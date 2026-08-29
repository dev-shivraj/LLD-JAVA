package practice.isp.part1.bird.goodDesign;

public class Penguin implements Bird, Swimmable {
    @Override
    public void eat() {
        System.out.println("Bird is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Bird is sleeping");
    }

    @Override
    public void swim() {
        System.out.println("Bird is swimming");
    }
}
