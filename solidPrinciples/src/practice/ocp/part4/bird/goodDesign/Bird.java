package practice.ocp.part4.bird.goodDesign;

public class Bird {

    private final MovementBehavior movementBehavior;

    public Bird(MovementBehavior movementBehavior) {
        this.movementBehavior = movementBehavior;
    }

    public void move() {
        movementBehavior.move();
    }
}