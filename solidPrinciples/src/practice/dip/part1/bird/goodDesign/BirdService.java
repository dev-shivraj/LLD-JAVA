package practice.dip.part1.bird.goodDesign;

public class BirdService {
    private final BirdRepository repository;

    public BirdService(BirdRepository repository) {
        this.repository = repository;
    }

    public void save(Bird bird) {
        repository.save(bird);
    }
}