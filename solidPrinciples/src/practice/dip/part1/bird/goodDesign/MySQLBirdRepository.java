package practice.dip.part1.bird.goodDesign;

public class MySQLBirdRepository implements BirdRepository {
    @Override
    public void save(Bird bird) {
        System.out.println("Saving " + bird.getName() + " to MySQL");
    }
}