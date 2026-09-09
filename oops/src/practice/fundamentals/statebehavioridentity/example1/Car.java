package practice.fundamentals.statebehavioridentity.example1;

public class Car {
    String brand;
    String color;
    int speed;

    void accelerate() {
        speed += 10;
    }

    void brake() {
        speed -= 10;
    }

    void displayState() {
        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
        System.out.println("Speed: " + speed);
    }
}
