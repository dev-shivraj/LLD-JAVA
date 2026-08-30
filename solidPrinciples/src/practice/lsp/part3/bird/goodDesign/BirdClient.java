package practice.lsp.part3.bird.goodDesign;

public class BirdClient {
    public static void main(String[] args) {
        Bird penguin = new Penguin();
        penguin.eat();
        penguin.sleep();

        FlyingBird sparrow = new Sparrow();
        sparrow.eat();
        sparrow.sleep();
        sparrow.fly();
    }
}