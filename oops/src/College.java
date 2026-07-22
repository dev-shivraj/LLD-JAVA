package src;

public class College {

    // Static variable
    private static String collegeName;

    /*
     * STATIC BLOCK
     *
     * This block will execute only when the College
     * class is initialized by the JVM.
     */
    static {
        System.out.println("========================================");
        System.out.println("COLLEGE STATIC BLOCK EXECUTED");
        System.out.println("========================================");

        collegeName = "ABC College";

        System.out.println("College class is loaded.");
        System.out.println("College Name: " + collegeName);
        System.out.println();
    }

    // Constructor
    public College() {
        System.out.println("College object created.");
    }

    // Instance method
    public void displayCollege() {
        System.out.println("College: " + collegeName);
    }
}