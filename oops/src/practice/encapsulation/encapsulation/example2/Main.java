package practice.encapsulation.encapsulation.example2;

public class Main {

    public static void main(String[] args) {

        Student student = new Student();

        student.setName("Shivraj");
        student.setAge(27);
        student.setMarks(85);

        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Marks: " + student.getMarks());

        System.out.println();

        student.setAge(-50);
        student.setMarks(-100);
        student.setMarks(150);

        System.out.println("After invalid updates:");

        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Marks: " + student.getMarks());
    }
}