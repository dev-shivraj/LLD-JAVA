package practice.ocp.part2.bird.badDesign;

public class BirdService {

    public void move(String birdType) {
        if (birdType.equals("SPARROW")) {
            System.out.println("Sparrow is flying");
        } else if (birdType.equals("EAGLE")) {
            System.out.println("Eagle is flying");
        } else if (birdType.equals("PENGUIN")) {
            System.out.println("Penguin is swimming");
        }
    }
}