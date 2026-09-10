package practice.fundamentals.defaultconstructor.example2;

public class Main {

    public static void main(String[] args) {

        Student student = new Student("Shivraj", 27);

        System.out.println("Name: " + student.name);
        System.out.println("Age: " + student.age);

        // This will NOT compile:
        // Student student2 = new Student();
    }
}