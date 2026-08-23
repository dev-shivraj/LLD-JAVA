package practice.ocp.part2.bird.goodDesign;

public class SwimmingMovement implements Movable {

    @Override
    public void move() {
        System.out.println("Bird is swimming");
    }
}