package practice.srp.part2.bird.badDesign;

public class Bird {

    // group 1 : core business responsibility
    public void eat() {
        System.out.println("Bird is eating");
    }

    // group 1 : core business responsibility
    public void sleep() {
        System.out.println("Bird is sleeping");
    }

    // group 1 : core business responsibility
    public void fly() {
        System.out.println("Bird is flying");
    }

    // group 1 : core business responsibility
    public void swim() {
        System.out.println("Bird is swimming");
    }

    // group 2 : persistence responsibility
    public void saveToDatabase() {
        System.out.println("Saving bird");
    }

    // group 3 : report responsibility
    public void generateReport() {
        System.out.println("Generating bird report");
    }

    // group 4 : communication responsibility
    public void sendNotification() {
        System.out.println("Sending bird notification");
    }
}