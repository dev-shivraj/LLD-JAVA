package practice.fundamentals.parameterizedconstructors.example3;

public class Car {

    String brand;
    String color;
    int speed;

    Car(String brand, String color, int speed) {
        this.brand = brand;
        this.color = color;
        this.speed = speed;
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
        System.out.println("Speed: " + speed);
    }
}