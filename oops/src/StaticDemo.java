package src;
/*
 * CLIENT CLASS - Demonstrates STATIC MEMBERS
 *
 * Key Points:
 * 1. Static variables are shared across ALL instances
 * 2. Static methods can be called without creating objects
 * 3. Static members are accessed via ClassName.member
 * 4. Instance variables are NOT accessible in static methods (directly)
 */

public class StaticDemo {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("START OF MAIN METHOD");
        System.out.println("Main method has started.");
        System.out.println("========================================\n");

        /*
         * We are NOT creating a College object here.
         *
         * Student class is used, but College class is not used.
         *
         * Therefore, the College static block will NOT execute.
         */


        System.out.println("========================================");
        System.out.println("DEMONSTRATION OF STATIC MEMBERS");
        System.out.println("========================================\n");

        // IMPORTANT: Static variables exist even before any object is created!
        System.out.println("--- BEFORE creating any Student objects ---");
        System.out.println("Total Students: " + Student.getTotalStudents());
        System.out.println("Highest GPA: " + Student.getHighestGPA());
        System.out.println("Institution: " + Student.getInstitution());
        System.out.println();


        System.out.println("========================================");
        System.out.println("DEMONSTRATION OF STATIC BLOCK");
        System.out.println("========================================");

        System.out.println("The Student class has already been loaded.");
        System.out.println();

        // Accessing a static method
        // This triggers class loading if Student was not loaded yet.
        System.out.println("Accessing Student static data...");
        System.out.println("Total Students: " + Student.getTotalStudents());
        System.out.println("Highest GPA: " + Student.getHighestGPA());
        System.out.println("Institution: " + Student.getInstitution());


        /*
         * At this point:
         *
         * Student static block -> EXECUTED
         * College static block -> NOT EXECUTED
         */
        System.out.println("\n========================================");
        System.out.println("NOW CREATING COLLEGE OBJECT");
        System.out.println("========================================");

        // Now College class is being used for the first time.
        // This will trigger the College static block to execute.
        College c1 = new College();
        c1.displayCollege();
        System.out.println("If we did not create a College object, the College static block would NOT have executed.");
        System.out.println("\n========================================");


        System.out.println("\nNow creating Student objects...\n");

        // Create first student
        System.out.println("--- Creating Student 1 ---");
        Student s1 = new Student("Alice", 20, 3.8);
        s1.displayInfo();
        System.out.println("Total Students so far: " + Student.getTotalStudents());
        System.out.println("Highest GPA so far: " + Student.getHighestGPA());
        System.out.println();

        // Create second student
        System.out.println("--- Creating Student 2 ---");
        Student s2 = new Student("Bob", 22, 3.5);
        s2.displayInfo();
        System.out.println("Total Students so far: " + Student.getTotalStudents());
        System.out.println("Highest GPA so far: " + Student.getHighestGPA());
        System.out.println();

        // Create third student with higher GPA
        System.out.println("--- Creating Student 3 ---");
        Student s3 = new Student("Charlie", 21, 3.95);
        s3.displayInfo();
        System.out.println("Total Students so far: " + Student.getTotalStudents());
        System.out.println("Highest GPA so far: " + Student.getHighestGPA());
        System.out.println();

        // Create fourth student
        System.out.println("--- Creating Student 4 ---");
        Student s4 = new Student("Diana", 20, 3.7);
        s4.displayInfo();
        System.out.println("Total Students so far: " + Student.getTotalStudents());
        System.out.println("Highest GPA so far: " + Student.getHighestGPA());
        System.out.println();

        // Display all static information
        System.out.println("========================================");
        System.out.println("FINAL STATISTICS (STATIC DATA)");
        System.out.println("========================================");
        Student.displayStatistics();
        System.out.println();

        // Static method to compare two students
        System.out.println("========================================");
        System.out.println("USING STATIC METHOD FOR COMPARISON");
        System.out.println("========================================");
        System.out.println("Top student between " + s1.getName() + " and " + s2.getName() + ": "
                + Student.getTopStudent(s1, s2));
        System.out.println("Top student between " + s2.getName() + " and " + s3.getName() + ": "
                + Student.getTopStudent(s2, s3));
        System.out.println();

        // Demonstrate that static variables are shared
        System.out.println("========================================");
        System.out.println("STATIC VARIABLES ARE SHARED");
        System.out.println("========================================");
        System.out.println("Accessing static members via different object references:");
        System.out.println("Via s1: Total Students = " + s1.getTotalStudents());
        System.out.println("Via s2: Total Students = " + s2.getTotalStudents());
        System.out.println("Via s3: Total Students = " + s3.getTotalStudents());
        System.out.println("Via s4: Total Students = " + s4.getTotalStudents());
        System.out.println("Via Student class: Total Students = " + Student.getTotalStudents());
        System.out.println("All show the SAME value (shared among all instances)\n");

        // Create more students
        System.out.println("========================================");
        System.out.println("CREATING MORE STUDENTS");
        System.out.println("========================================\n");

        Student s5 = new Student("Eve", 19, 3.9);
        s5.displayInfo();
        System.out.println("Total Students: " + Student.getTotalStudents() + "\n");

        Student s6 = new Student("Frank", 21, 4.0);
        s6.displayInfo();
        System.out.println("Total Students: " + Student.getTotalStudents() + "\n");

        // Display updated statistics
        System.out.println("========================================");
        System.out.println("UPDATED STATISTICS");
        System.out.println("========================================");
        Student.displayStatistics();
        System.out.println();

        // Reset statistics
        System.out.println("========================================");
        System.out.println("RESETTING STATIC DATA");
        System.out.println("========================================");
        Student.resetStatistics();
        System.out.println("After reset:");
        System.out.println("Total Students: " + Student.getTotalStudents());
        System.out.println("Highest GPA: " + Student.getHighestGPA());
        System.out.println();

        // Create new student after reset
        System.out.println("Creating new student after reset:");
        Student s7 = new Student("Grace", 20, 3.6);
        s7.displayInfo();
        System.out.println("Total Students after reset and new creation: " + Student.getTotalStudents());
        System.out.println("Highest GPA: " + Student.getHighestGPA());
        System.out.println();

        // Key insights
        System.out.println("========================================");
        System.out.println("KEY INSIGHTS ABOUT STATIC MEMBERS");
        System.out.println("========================================");
        System.out.println("✓ Static variables belong to the CLASS, not instances");
        System.out.println("✓ All instances SHARE the same static variables");
        System.out.println("✓ Static methods can be called WITHOUT creating objects");
        System.out.println("✓ Static methods cannot directly access instance variables");
        System.out.println("✓ Static variables are initialized only ONCE when class loads");
        System.out.println("✓ Static final variables are CONSTANTS (cannot be changed)");
        System.out.println("✓ Accessing via obj.staticMember is allowed but NOT recommended");
    }
}
