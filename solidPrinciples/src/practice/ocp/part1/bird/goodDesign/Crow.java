package practice.ocp.part1.bird.goodDesign;

public class Crow implements Bird {

    @Override
    public void makeSound() {
        System.out.println("Crow: Caw");
    }
}