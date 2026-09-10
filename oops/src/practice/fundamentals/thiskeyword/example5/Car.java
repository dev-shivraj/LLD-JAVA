package practice.fundamentals.thiskeyword.example5;

public class Car {

    void checkIdentity(Car car) {

        System.out.println("this == car: " + (this == car));
    }
}