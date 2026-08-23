package practice.ocp.part1.bird.goodDesign;

import practice.ocp.part1.bird.goodDesign.newRequirement.Eagle;

public class BIrdClient {
    public static void main(String[] args) {
        // existing design
        Bird crow = new Crow();
        Bird duck = new Duck();

        // new requirement
        Bird eagle = new Eagle();



        // existing design
        crow.makeSound();
        duck.makeSound();

        // new requirement
        eagle.makeSound();

    }
}
