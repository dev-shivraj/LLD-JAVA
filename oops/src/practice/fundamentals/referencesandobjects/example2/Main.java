package practice.fundamentals.referencesandobjects.example2;

public class Main {

    public static void main(String[] args) {

        Car car1 = new Car("BMW");
        Car car2 = new Car("Audi");

        System.out.println("Before reassignment:");
        System.out.println("car1: " + car1.brand);
        System.out.println("car2: " + car2.brand);

        car1 = car2;

        System.out.println();
        System.out.println("After reassignment:");
        System.out.println("car1: " + car1.brand);
        System.out.println("car2: " + car2.brand);

        System.out.println();
        System.out.println("Same object?");
        System.out.println(car1 == car2);
    }
}