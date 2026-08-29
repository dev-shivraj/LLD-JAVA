package practice.isp.part3.bird.badDesign;

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
        throw new UnsupportedOperationException();
    }

    @Override
    public void swim() {
        System.out.println("Penguin is swimming");
    }

    @Override
    public void sing() {
        throw new UnsupportedOperationException();
    }
}