package practice.introduction.part1.birds.badDesign;

public class Bird {
    // Bird behavior
    public void eat() {
        System.out.println("Bird is eating");
    }

    // Bird behavior
    public void sleep() {
        System.out.println("Bird is sleeping");
    }

    // Bird behavior
    public void fly() {
        System.out.println("Bird is flying");
    }

    // Bird behavior
    public void swim() {
        System.out.println("Bird is swimming");
    }

    // Persistence responsibility
    public void saveToDatabase() {
        System.out.println("Saving bird to database");
    }

    // report responsibility
    public void generateReport() {
        System.out.println("Generating bird report");
    }

    // communication responsibility
    public void sendNotification() {
        System.out.println("Sending notification");
    }
}
