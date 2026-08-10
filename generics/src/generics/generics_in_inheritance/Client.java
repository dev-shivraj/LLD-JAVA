package generics.generics_in_inheritance;

import java.util.ArrayList;
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

    // wildcard generics
    static void printAnimalNames2(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.getName());
        }
    }

    // wildcard generics
    static void addANimal(List<? super Creature> animals) {
        animals.add(new Dog("Dog3"));
        animals.add(new Animal("Animal1"));
    }

    // wildcard generics : both upper and lower bound
    // it is loosly coupled and not type safe, so it is not recommended to use it
    static void xxx(List<?> x) {

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


        System.out.println("================================================================");
        List<Dog> listDogs2 = List.of(new Dog("Dog1"), new Dog("Dog2"));
        // This line will not cause a compilation error now
        // because List<Dog> is a subtype of List<? extends Animal>
         printAnimalNames2(listDogs2);
        System.out.println("================================================================");


        System.out.println("================================================================");

        List<Creature> listCreatures = new ArrayList<>();
        // This line will not cause a compilation error now
        // because List<Creature> is a subtype of List<? super Animal>
        addANimal(listCreatures);

        // This line will not cause a compilation error now
        // because List<Dog> is a subtype of List<? super Creature>
        // it is not supertype of List<Animal> but it is supertype of List<Creature>
        // addANimal(listDogs2);
        System.out.println("================================================================");
    }
}
