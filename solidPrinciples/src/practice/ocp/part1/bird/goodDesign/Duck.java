package practice.ocp.part1.bird.goodDesign;

public class Duck implements Bird {

    @Override
    public void makeSound() {
        System.out.println("Duck: Quack");
    }
}