package practice.dip.part1.bird.goodDesign;

public class BirdClient {
    public static void main(String[] args) {
        Bird bird = new Bird("Penguin");
        BirdRepository repository = new MySQLBirdRepository();
        BirdService service = new BirdService(repository);
        service.save(bird);
        System.out.println("----------------");

        repository = new MongoBirdRepository();
        service = new BirdService(repository);
        service.save(bird);
    }
}