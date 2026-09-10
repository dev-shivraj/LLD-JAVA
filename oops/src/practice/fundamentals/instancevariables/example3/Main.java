package practice.fundamentals.instancevariables.example3;

public class Main {

    public static void main(String[] args) {

        Laptop laptop1 = new Laptop();
        Laptop laptop2 = new Laptop();

        System.out.println("Laptop 1 RAM: " + laptop1.ram);
        System.out.println("Laptop 2 RAM: " + laptop2.ram);

        laptop1.ram = 16;

        System.out.println();
        System.out.println("After changing laptop1:");

        System.out.println("Laptop 1 RAM: " + laptop1.ram);
        System.out.println("Laptop 2 RAM: " + laptop2.ram);
    }
}