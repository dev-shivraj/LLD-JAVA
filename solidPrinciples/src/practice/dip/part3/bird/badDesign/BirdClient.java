package practice.dip.part3.bird.badDesign;

public class BirdClient {

    public static void main(String[] args) {

        Bird bird =
                new Bird("Penguin");

        BirdService service =
                new BirdService();

        service.processBird(bird);
    }
}