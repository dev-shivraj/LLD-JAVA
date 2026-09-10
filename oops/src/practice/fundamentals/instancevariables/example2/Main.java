package practice.fundamentals.instancevariables.example2;

public class Main {

    public static void main(String[] args) {

        Student student = new Student();

        System.out.println("Name: " + student.name);
        System.out.println("Age: " + student.age);
        System.out.println("Marks: " + student.marks);
        System.out.println("Active: " + student.active);
        System.out.println("Grade: " + student.grade);
    }
}