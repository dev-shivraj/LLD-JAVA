package practice.introduction.part1.birds.badDesign;

public class BirdService {

    // Bird behavior
    public void eat(Bird bird) {
        System.out.println("Bird is eating");
    }

    // Bird behavior
    public void fly(Bird bird) {
        System.out.println("Bird is flying");
    }

    // Persistence responsibility
    public void saveBird(Bird bird) {
        System.out.println("Saving bird to database");
    }

    // report responsibility
    public void generateReport(Bird bird) {
        System.out.println("Generating bird report");
    }

    // communication responsibility
    public void sendNotification(Bird bird) {
        System.out.println("Sending notification");
    }
}