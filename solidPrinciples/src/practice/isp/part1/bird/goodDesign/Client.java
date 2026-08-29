package practice.isp.part1.bird.goodDesign;

public class Client {
    public static void main(String[] args) {
        Penguin penguin = new Penguin();
        Sparrow sparrow = new Sparrow();

        penguin.eat();
        penguin.sleep();
        penguin.swim();

        System.out.println();
        sparrow.eat();
        sparrow.sleep();
        sparrow.fly();
    }
}
