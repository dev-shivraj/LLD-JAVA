package practice.fundamentals.classandobjects.example1;

public class Car {
    String brand;
    String color;

    void drive() {
        System.out.println(brand + " car is driving");
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
    }
}
