package practice.dip.part1.bird.badDesign;

public class BirdClient {
    public static void main(String[] args) {
        Bird bird = new Bird("Penguin");
        BirdService service = new BirdService();
        service.save(bird);
    }
}