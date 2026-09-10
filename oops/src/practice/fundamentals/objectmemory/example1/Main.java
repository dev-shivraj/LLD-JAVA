package practice.fundamentals.objectmemory.example1;

public class Main {

    public static void main(String[] args) {

        Car car = new Car();

        car.brand = "BMW";
        car.speed = 100;
        car.engine = new Engine("Petrol");

        System.out.println("Brand: " + car.brand);
        System.out.println("Speed: " + car.speed);
        System.out.println("Engine: " + car.engine.type);
    }
}