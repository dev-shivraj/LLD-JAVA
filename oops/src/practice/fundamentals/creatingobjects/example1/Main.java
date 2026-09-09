package practice.fundamentals.creatingobjects.example1;

public class Main {

    public static void main(String[] args) {

        Car car = new Car();

        System.out.println("Brand: " + car.brand);
        System.out.println("Color: " + car.color);
        System.out.println("Speed: " + car.speed);
        System.out.println("Running: " + car.running);
    }
}