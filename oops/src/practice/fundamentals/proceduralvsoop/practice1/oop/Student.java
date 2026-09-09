package practice.fundamentals.proceduralvsoop.practice1.oop;

public class Student {
    String name;
    int age;
    String course;

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }

    void study() {
        System.out.println(name + " is studying");
    }
}
