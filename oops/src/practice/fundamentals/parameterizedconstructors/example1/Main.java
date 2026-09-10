package practice.fundamentals.parameterizedconstructors.example1;

public class Main {

    public static void main(String[] args) {

        Student student = new Student(
                "Shivraj",
                27,
                "Java"
        );

        student.displayInfo();
    }
}