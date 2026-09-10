package practice.fundamentals.thiskeyword.example5;

public class Main {

    public static void main(String[] args) {

        Car car1 = new Car();
        Car car2 = new Car();

        car1.checkIdentity(car1);
        car1.checkIdentity(car2);
    }
}