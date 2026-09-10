package practice.fundamentals.defaultconstructor.practice1;

public class Main {

    public static void main(String[] args) {

        Laptop laptop = new Laptop();

        System.out.println("Default values:");

        System.out.println("Brand: " + laptop.brand);
        System.out.println("RAM: " + laptop.ram);
        System.out.println("Price: " + laptop.price);

        laptop.brand = "Apple";
        laptop.ram = 16;
        laptop.price = 150000;

        System.out.println();
        System.out.println("After assigning values:");

        System.out.println("Brand: " + laptop.brand);
        System.out.println("RAM: " + laptop.ram);
        System.out.println("Price: " + laptop.price);
    }
}