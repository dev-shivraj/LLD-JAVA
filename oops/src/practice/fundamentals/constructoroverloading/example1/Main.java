package practice.fundamentals.constructoroverloading.example1;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student();
        Student student2 = new Student("Shivraj");
        Student student3 = new Student("Rahul", 25);
        Student student4 = new Student("Amit", 30, "Java");

        System.out.println("Student 1:");
        student1.displayInfo();

        System.out.println();

        System.out.println("Student 2:");
        student2.displayInfo();

        System.out.println();

        System.out.println("Student 3:");
        student3.displayInfo();

        System.out.println();

        System.out.println("Student 4:");
        student4.displayInfo();
    }
}