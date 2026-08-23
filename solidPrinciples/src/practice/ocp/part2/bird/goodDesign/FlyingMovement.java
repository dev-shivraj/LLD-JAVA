package practice.ocp.part2.bird.goodDesign;

public class FlyingMovement implements Movable {

    @Override
    public void move() {
        System.out.println("Bird is flying");
    }
}