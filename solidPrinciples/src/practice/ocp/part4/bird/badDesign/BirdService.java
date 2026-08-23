package practice.ocp.part4.bird.badDesign;

public class BirdService {

    public void move(String birdType) {

        if (birdType.equals("SPARROW")) {
            System.out.println("Sparrow flies");
        } else if (birdType.equals("EAGLE")) {
            System.out.println("Eagle flies");
        } else if (birdType.equals("PENGUIN")) {
            System.out.println("Penguin swims");
        }
    }
}