package practice.fundamentals.referencesandobjects.practice1;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student();
        student1.name = "Shivraj";
        student1.age = 27;
        student1.course = "Java";

        Student student2 = student1;

        System.out.println("Before changing through student2:");
        System.out.println("student1 course: " + student1.course);
        System.out.println("student2 course: " + student2.course);

        student2.course = "Spring Boot";

        System.out.println();
        System.out.println("After changing through student2:");
        System.out.println("student1 course: " + student1.course);
        System.out.println("student2 course: " + student2.course);

        System.out.println();
        System.out.println("student1 == student2: " + (student1 == student2));

        Student student3 = new Student();

        System.out.println("student1 == student3: " + (student1 == student3));
        System.out.println("student2 == student3: " + (student2 == student3));
    }
}