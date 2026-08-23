package practice.ocp.part1.bird.badDesign;

class BirdService {

    public void makeSound(String birdType) {
        if (birdType.equals("CROW")) {
            System.out.println("Crow: Caw");
        } else if (birdType.equals("SPARROW")) {
            System.out.println("Sparrow: Chirp");
        } else if (birdType.equals("DUCK")) {
            System.out.println("Duck: Quack");
        }
    }
}