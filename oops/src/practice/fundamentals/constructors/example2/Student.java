package practice.fundamentals.constructors.example2;

public class Student {

    String name;
    int age;
    String course;

    Student() {
        name = "Unknown";
        age = 0;
        course = "Not Assigned";
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }
}