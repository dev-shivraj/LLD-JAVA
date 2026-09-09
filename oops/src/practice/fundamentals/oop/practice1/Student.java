package practice.fundamentals.oop.practice1;

public class Student {
    String name;
    int age;
    String course;

    void study() {
        System.out.println(name + " is studying");
    }

    void attendClass() {
        System.out.println(name + " is attending class");
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }
}
