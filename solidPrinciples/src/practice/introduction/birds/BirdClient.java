package practice.introduction.birds;

public class BirdClient {
    public static void main(String[] args) {
        Bird bird = new Bird();

        bird.eat();
        bird.sleep();
        bird.fly();
        bird.swim();
        bird.saveToDatabase();
        bird.generateReport();
        bird.sendNotification();



        // ====================================
        Penguin penguin = new Penguin();

        System.out.println("-------------------------");
        penguin.eat();
        penguin.sleep();
        penguin.fly();


        // ====================================
    }
}
