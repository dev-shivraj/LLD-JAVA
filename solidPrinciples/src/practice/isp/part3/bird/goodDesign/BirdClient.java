package practice.isp.part3.bird.goodDesign;

public class BirdClient {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        sparrow.eat();
        sparrow.sleep();
        System.out.println("----------------");

        Flyable flyingBird = new Sparrow();
        flyingBird.fly();
        System.out.println("----------------");

        Bird penguin = new Penguin();
        penguin.eat();
        penguin.sleep();
        System.out.println("----------------");

        Swimmable swimmingBird = new Penguin();
        swimmingBird.swim();
        System.out.println("----------------");

        Flyable eagle = new Eagle();
        eagle.fly();
    }
}