package practice.fundamentals.oop.example2;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        car.brand = "BMW";
        car.color = "Red";
        car.speed = 50;

        System.out.println("Brand: " + car.brand);
        System.out.println("Color: " + car.color);
        System.out.println("Speed: " + car.speed);

        car.accelerate();
        System.out.println("After acceleration: " + car.speed);

        car.brake();
        System.out.println("After braking: " + car.speed);
    }
}
