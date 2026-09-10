package practice.fundamentals.thiskeyword.example1;

public class Main {

    public static void main(String[] args) {

        Car car = new Car();

        car.brand = "BMW";
        car.speed = 50;

        car.displayInfo();

        car.accelerate();

        car.displayInfo();
    }
}