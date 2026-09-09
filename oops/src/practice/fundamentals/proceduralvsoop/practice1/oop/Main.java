package practice.fundamentals.proceduralvsoop.practice1.oop;


public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "Shivraj";
        student1.age = 27;
        student1.course = "LLD";

        Student student2 = new Student();
        student2.name = "RAJ";
        student2.age = 25;
        student2.course = "Spring Boot";

        student1.displayInfo();
        student1.study();

        System.out.println();

        student2.displayInfo();
        student2.study();
    }
}
