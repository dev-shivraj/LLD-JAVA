package practice.dip.part1.bird.badDesign;

public class BirdService {
    private final MySQLBirdRepository repository = new MySQLBirdRepository();

    public void save(Bird bird) {
        repository.save(bird);
    }
}