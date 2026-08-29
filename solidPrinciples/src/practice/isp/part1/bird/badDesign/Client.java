package practice.isp.part1.bird.badDesign;

public class Client {
    public static void main(String[] args) {
        Penguin penguin = new Penguin();
        penguin.eat();
        penguin.sleep();
        penguin.swim();
        penguin.fly();
    }
}
