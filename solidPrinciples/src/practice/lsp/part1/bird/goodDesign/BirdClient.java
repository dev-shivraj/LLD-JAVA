package practice.lsp.part1.bird.goodDesign;

public class BirdClient {
    public static void makeBirdFly(FlyingBird bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        FlyingBird sparrow = new Sparrow();
        makeBirdFly(sparrow);

        Bird penguin = new Penguin();
        penguin.eat();
        penguin.sleep();
    }
}