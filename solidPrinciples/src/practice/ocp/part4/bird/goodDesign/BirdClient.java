package practice.ocp.part4.bird.goodDesign;

public class BirdClient {

    public static void main(String[] args) {

        Bird sparrow = new Bird(new FlyingMovement());
        sparrow.move();

        Bird penguin = new Bird(new SwimmingMovement());
        penguin.move();
    }
}