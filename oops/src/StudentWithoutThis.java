package src;

/*
 * WITHOUT this keyword - AMBIGUOUS CODE
 * When parameter names match instance variable names,
 * the parameter shadows the instance variable.
 * This causes confusion and bugs.
 */

public class StudentWithoutThis {
    private String name;
    private int age;
    private double gpa;

    // Constructor WITHOUT this keyword - PROBLEMATIC
    public StudentWithoutThis(String name, int age, double gpa) {
        // These assignments are AMBIGUOUS!
        // 'name' refers to the parameter, not the instance variable
        // The instance variable 'name' is never assigned!
        name = name;  // This does NOTHING - just assigns parameter to itself
        age = age;    // This does NOTHING - just assigns parameter to itself
        gpa = gpa;    // This does NOTHING - just assigns parameter to itself
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", GPA: " + gpa);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }
}
