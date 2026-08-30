package practice.lsp.part1.bird.badDesign;

public class BirdClient {
    public static void makeBirdFly(Bird bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        makeBirdFly(sparrow);

        Bird penguin = new Penguin();
        makeBirdFly(penguin);
    }
}