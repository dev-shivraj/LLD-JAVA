package src;

public class StudentClient {
    public static void main(String args[]) {
        System.out.println("========================================");
        System.out.println("WITHOUT 'this' keyword - PROBLEMATIC");
        System.out.println("========================================\n");

        // Creating object without this - constructor parameters shadow instance variables
        StudentWithoutThis student1 = new StudentWithoutThis("Alice", 20, 3.8);
        System.out.println("Created: StudentWithoutThis(\"Alice\", 20, 3.8)");
        student1.displayInfo();
        System.out.println("Expected: Name: Alice, Age: 20, GPA: 3.8");
        System.out.println("Got: Name: null, Age: 0, GPA: 0.0");
        System.out.println("Problem: Parameters shadow instance variables, so assignment fails!\n");


        System.out.println("========================================");
        System.out.println("WITH 'this' keyword - CORRECT");
        System.out.println("========================================\n");

        // Creating objects with this - clear and works correctly
        StudentWithThis student2 = new StudentWithThis("Alice", 20, 3.8);
        System.out.println("Created: StudentWithThis(\"Alice\", 20, 3.8)");
        student2.displayInfo();
        System.out.println("Expected: Name: Alice, Age: 20, GPA: 3.8");
        System.out.println("Got: Name: Alice, Age: 20, GPA: 3.8\n");

        // Constructor chaining with this()
        StudentWithThis student3 = new StudentWithThis("Bob", 22);
        System.out.println("Created: StudentWithThis(\"Bob\", 22) - default GPA");
        student3.displayInfo();
        System.out.println();

        StudentWithThis student4 = new StudentWithThis("Charlie");
        System.out.println("Created: StudentWithThis(\"Charlie\") - default age and GPA");
        student4.displayInfo();
        System.out.println();

        StudentWithThis student5 = new StudentWithThis();
        System.out.println("Created: StudentWithThis() - all defaults");
        student5.displayInfo();
        System.out.println();

        // Updating using this keyword
        System.out.println("========================================");
        System.out.println("Using 'this' in methods");
        System.out.println("========================================\n");

        student3.updateStudent("Alice Cooper", 21, 3.9);
        System.out.println("After updateStudent(\"Alice Cooper\", 21, 3.9):");
        student3.displayInfo();
        System.out.println();

        System.out.println("========================================");
        System.out.println("Key Benefits of 'this' keyword:");
        System.out.println("========================================");
        System.out.println("1. Clarity: Shows you're referring to instance variables");
        System.out.println("2. Shadowing Prevention: Handles same-named parameters correctly");
        System.out.println("3. Constructor Chaining: this() reduces code duplication");
        System.out.println("4. Method Readability: Makes code intent explicit");
    }
}
