package practice.fundamentals.referencesandobjects.example1;

public class Main {

    public static void main(String[] args) {

        Car car1 = new Car();
        car1.brand = "BMW";
        car1.speed = 50;

        Car car2 = car1;

        System.out.println("Before changing through car2:");
        System.out.println("car1 brand: " + car1.brand);
        System.out.println("car1 speed: " + car1.speed);

        car2.speed = 100;

        System.out.println();
        System.out.println("After changing through car2:");
        System.out.println("car1 speed: " + car1.speed);
        System.out.println("car2 speed: " + car2.speed);

        System.out.println();
        System.out.println("Are car1 and car2 referring to same object?");
        System.out.println(car1 == car2);
    }
}