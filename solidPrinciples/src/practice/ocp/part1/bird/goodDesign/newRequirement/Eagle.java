package practice.ocp.part1.bird.goodDesign.newRequirement;

import practice.ocp.part1.bird.goodDesign.Bird;

public class Eagle implements Bird {

    @Override
    public void makeSound() {
        System.out.println("Eagle sound");
    }
}