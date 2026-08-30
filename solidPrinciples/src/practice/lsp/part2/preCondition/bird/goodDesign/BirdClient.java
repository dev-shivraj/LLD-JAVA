package practice.lsp.part2.preCondition.bird.goodDesign;

public class BirdClient {
    public static void main(String[] args) {
        Bird bird = new Sparrow();
        bird.fly(50);
    }
}