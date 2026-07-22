package src;

/*
 * Demonstrates STATIC MEMBERS and STATIC BLOCK in Java
 *
 * Static members:
 * - Belong to the CLASS, not individual objects
 * - Shared across ALL instances of the class
 * - Accessed using ClassName.staticMember
 * - Initialized only once when the class is loaded
 *
 *
 * Static block:
 * - Executes automatically when the class is loaded
 * - Executes only ONCE
 * - Executes BEFORE main() uses the Student class
 */

public class Student {

    // Instance variables - each object has its own copy
    private String name;
    private int age;
    private double gpa;

    // STATIC VARIABLE - shared by ALL instances
    private static int totalStudents = 0;

    // STATIC CONSTANT
    private static final String INSTITUTION = "ABC University";

    // STATIC VARIABLE - tracks highest GPA
    private static double highestGPA = 0.0;

    /*
     * STATIC BLOCK
     *
     * This block executes automatically ONCE when the Student
     * class is loaded into memory.
     *
     * It executes BEFORE the first Student object is created.
     *
     * Static blocks are commonly used for:
     * - Initializing static variables
     * - Loading configuration
     * - Performing one-time setup
     */
    static {
        System.out.println("========================================");
        System.out.println("STATIC BLOCK EXECUTED");
        System.out.println("========================================");
        System.out.println("Student class is being loaded...");
        System.out.println("Initializing static data...");

        totalStudents = 0;
        highestGPA = 0.0;

        System.out.println("Institution: " + INSTITUTION);
        System.out.println("Initial Total Students: " + totalStudents);
        System.out.println("Initial Highest GPA: " + highestGPA);
        System.out.println("Static block execution completed!");
        System.out.println("========================================\n");
    }

    // Constructor
    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;

        // Increment total students
        totalStudents++;

        // Update highest GPA
        if (gpa > highestGPA) {
            highestGPA = gpa;
        }

        System.out.println("✓ Student created: " + name);
    }

    // Instance method
    public void displayInfo() {
        System.out.println(
                "Name: " + name +
                        ", Age: " + age +
                        ", GPA: " + gpa
        );
    }

    // STATIC METHOD
    public static void displayStatistics() {
        System.out.println("\n--- STATIC DATA (Shared across all instances) ---");
        System.out.println("Institution: " + INSTITUTION);
        System.out.println("Total Students Created: " + totalStudents);
        System.out.println("Highest GPA: " + highestGPA);
    }

    // STATIC METHOD
    public static int getTotalStudents() {
        return totalStudents;
    }

    // STATIC METHOD
    public static double getHighestGPA() {
        return highestGPA;
    }

    // STATIC METHOD
    public static String getInstitution() {
        return INSTITUTION;
    }

    // STATIC METHOD
    public static void resetStatistics() {
        System.out.println("Resetting statistics...");
        totalStudents = 0;
        highestGPA = 0.0;
    }

    // Instance method
    public String getName() {
        return name;
    }

    // Instance method
    public double getGpa() {
        return gpa;
    }

    // STATIC METHOD
    public static String getTopStudent(Student s1, Student s2) {
        if (s1.gpa > s2.gpa) {
            return s1.name + " (GPA: " + s1.gpa + ")";
        } else if (s2.gpa > s1.gpa) {
            return s2.name + " (GPA: " + s2.gpa + ")";
        } else {
            return "Both have same GPA: " + s1.gpa;
        }
    }
}