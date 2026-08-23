package practice.ocp.part4.bird.goodDesign;

public class FlyingMovement implements MovementBehavior {

    @Override
    public void move() {
        System.out.println("Bird is flying");
    }
}