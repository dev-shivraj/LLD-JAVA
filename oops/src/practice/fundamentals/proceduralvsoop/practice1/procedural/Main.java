package practice.fundamentals.proceduralvsoop.practice1.procedural;

import practice.fundamentals.oop.practice1.Student;

public class Main {
    public static void main(String[] args) {
        String name1 = "Rahul";
        int age1 = 21;
        String course1 = "Java";

        String name2 = "Priya";
        int age2 = 22;
        String course2 = "Spring Boot";

        StudentOperations.displayStudent(name1, age1, course1);
        StudentOperations.study(name1);

        System.out.println();

        StudentOperations.displayStudent(name2, age2, course2);
        StudentOperations.study(name2);
    }
}
