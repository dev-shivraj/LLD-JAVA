package practice.isp.part2.bird.badDesign;

public class Penguin implements Bird {
    @Override
    public void eat() {
        System.out.println("Penguin is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Penguin is sleeping");
    }

    @Override
    public void fly() {
        System.out.println("Penguin cannot fly");
    }

    @Override
    public void swim() {
        System.out.println("Penguin is swimming");
    }

    @Override
    public void sing() {
        System.out.println("Penguin does not sing");
    }
}