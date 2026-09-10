package practice.fundamentals.constructorchaining.example2;

public class Car {

    String brand;
    String color;
    int speed;

    Car() {
        this("Unknown");
    }

    Car(String brand) {
        this(brand, "Unknown");
    }

    Car(String brand, String color) {
        this(brand, color, 0);
    }

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