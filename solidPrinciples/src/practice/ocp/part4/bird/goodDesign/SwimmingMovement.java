package practice.ocp.part4.bird.goodDesign;

public class SwimmingMovement implements MovementBehavior {

    @Override
    public void move() {
        System.out.println("Bird is swimming");
    }
}