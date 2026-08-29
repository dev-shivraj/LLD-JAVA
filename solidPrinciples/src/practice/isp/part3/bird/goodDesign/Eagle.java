package practice.isp.part3.bird.goodDesign;

public class Eagle implements Bird, Flyable {
    @Override
    public void eat() {
        System.out.println("Eagle is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Eagle is sleeping");
    }

    @Override
    public void fly() {
        System.out.println("Eagle is flying");
    }
}