package practice.fundamentals.thiskeyword.example1;

public class Car {

    String brand;
    int speed;

    void displayInfo() {
        System.out.println("Brand: " + this.brand);
        System.out.println("Speed: " + this.speed);
    }

    void accelerate() {
        this.speed += 10;
    }
}