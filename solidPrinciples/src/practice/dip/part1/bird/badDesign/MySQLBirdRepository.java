package practice.dip.part1.bird.badDesign;

public class MySQLBirdRepository {
    public void save(Bird bird) {
        System.out.println("Saving " + bird.getName() + " to MySQL");
    }
}