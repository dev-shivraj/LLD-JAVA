package practice.isp.part2.bird.badDesign;

public class BirdClient {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        sparrow.eat();
        sparrow.sleep();
        sparrow.fly();
        sparrow.swim();
        sparrow.sing();
        System.out.println("----------------");

        Bird penguin = new Penguin();
        penguin.eat();
        penguin.sleep();
        penguin.fly();
        penguin.swim();
        penguin.sing();
    }
}