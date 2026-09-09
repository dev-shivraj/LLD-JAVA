package practice.fundamentals.oop.practice1;

public class Main {
    static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "Rahul";
        student1.age = 21;
        student1.course = "Java";

        Student student2 = new Student();
        student2.name = "Priya";
        student2.age = 22;
        student2.course = "Spring Boot";

        student1.displayInfo();
        student1.study();
        student1.attendClass();

        System.out.println();
        student2.displayInfo();
        student2.study();
        student2.attendClass();
    }
}
