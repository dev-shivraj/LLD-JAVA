package practice.isp.part2.bird.goodDesign;

public class Penguin implements Bird, Swimmable {
    @Override
    public void eat() {
        System.out.println("Penguin is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Penguin is sleeping");
    }

    @Override
    public void swim() {
        System.out.println("Penguin is swimming");
    }
}