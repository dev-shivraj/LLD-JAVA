package src;

/*
 * WITH this keyword - CLEAR AND EXPLICIT
 * 'this' refers to the current object instance.
 * It disambiguates between parameters and instance variables.
 */

public class StudentWithThis {
    private String name;
    private int age;
    private double gpa;

    // Primary Constructor WITH this keyword - CLEAR
    public StudentWithThis(String name, int age, double gpa) {
        // 'this.name' refers to instance variable
        // 'name' refers to parameter
        // No ambiguity!
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    // Constructor with default GPA - uses this() to call another constructor
    public StudentWithThis(String name, int age) {
        // this() calls another constructor in the same class
        // This reduces code duplication
        this(name, age, 0.0);
    }

    // Constructor with only name - uses this() for constructor chaining
    public StudentWithThis(String name) {
        // Constructor chaining: calls the 2-param constructor
        this(name, 0);
    }

    // Parameterless constructor - uses this() for full initialization
    public StudentWithThis() {
        // Calls the 1-param constructor
        this("Unknown");
    }

    public void displayInfo() {
        System.out.println("Name: " + this.name + ", Age: " + this.age + ", GPA: " + this.gpa);
    }

    public void updateStudent(String name, int age, double gpa) {
        // Using 'this' to refer to instance variables in method
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getGpa() {
        return this.gpa;
    }
}
