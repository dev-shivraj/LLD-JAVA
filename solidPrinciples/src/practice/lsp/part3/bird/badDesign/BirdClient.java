package practice.lsp.part3.bird.badDesign;

public class BirdClient {
    public static void main(String[] args) {
        Bird bird = new Penguin();
        bird.eat();
        bird.sleep();
        bird.fly();
    }
}