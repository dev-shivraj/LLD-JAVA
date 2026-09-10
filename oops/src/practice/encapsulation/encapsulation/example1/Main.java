package practice.encapsulation.encapsulation.example1;

public class Main {

    public static void main(String[] args) {

        Student student = new Student();

        student.name = "Shivraj";
        student.age = -50;
        student.marks = -100;

        System.out.println("Name: " + student.name);
        System.out.println("Age: " + student.age);
        System.out.println("Marks: " + student.marks);
    }
}