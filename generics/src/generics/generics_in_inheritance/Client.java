package generics.generics_in_inheritance;

import java.util.List;

public class Client {
    static void printAnimalName(Animal animal) {
        System.out.println(animal.getName());
    }

    static void printAnimalNames(List<Animal> animals) {
        for (Animal animal : animals) {
                System.out.println(animal.getName());
        }
    }

    static void main() {
        System.out.println("================================================================");
        Animal tiger = new Animal("Tiger");
        printAnimalName(tiger);
        System.out.println("================================================================");


        System.out.println("================================================================");
        Animal dog = new Dog("Dog");
        printAnimalName(dog);
        System.out.println("================================================================");


        System.out.println("================================================================");
        List<Animal> animals = List.of(tiger, dog);
        printAnimalNames(animals);
        System.out.println("================================================================");

        System.out.println("================================================================");
        List<Dog> dogs = List.of(new Dog("Dog1"), new Dog("Dog2"));
        // This line will cause a compilation error
        // because List<Dog> is not a subtype of List<Animal>
        // actually Dog is a subtype of Animal, but List<Dog> is not a subtype of List<Animal>
        // printAnimalNames(dogs);
        System.out.println("================================================================");

    }
}
