package practice.fundamentals.constructoroverloading.example1;

public class Student {

    String name;
    int age;
    String course;

    Student() {
        name = "Unknown";
        age = 0;
        course = "Not Assigned";
    }

    Student(String name) {
        this.name = name;
        age = 0;
        course = "Not Assigned";
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
        course = "Not Assigned";
    }

    Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }
}