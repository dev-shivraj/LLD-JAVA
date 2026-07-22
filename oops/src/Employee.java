package src;
/*
 * Demonstrates COMPLETE STATIC CONCEPTS:
 * 1. Static variables
 * 2. Static constants
 * 3. Static methods
 * 4. Static blocks
 * 5. Instance variables and methods
 */

public class Employee {

    // ========== STATIC MEMBERS (Shared across ALL instances) ==========

    // Static variable - shared by all employees
    private static int totalEmployees = 0;

    // Static variable - tracks total salary paid
    private static double totalSalaryPaid = 0.0;

    // Static constant - cannot be changed after initialization
    private static final String COMPANY_NAME = "Tech Solutions Inc.";

    // Static variable - company founding year
    private static final int COMPANY_FOUNDED = 2010;

    // Static variable - default bonus percentage
    private static double defaultBonusPercentage = 5.0;

    // Static variable - will be initialized in static block
    private static String[] departments;

    // ========== INSTANCE MEMBERS (Each object has its own copy) ==========

    private String employeeName;
    private int employeeId;
    private String department;
    private double salary;
    private int yearsWorked;


    // ========== STATIC BLOCK - Runs ONCE when class is FIRST loaded ==========
    // Used for static initialization that can't be done in variable declaration
    static {
        System.out.println("\n*** STATIC BLOCK EXECUTED (Class loaded into memory) ***\n");
        System.out.println("Initializing static members...");
        System.out.println("Company: " + COMPANY_NAME);
        System.out.println("Founded: " + COMPANY_FOUNDED);

        // Initialize departments array
        departments = new String[]{"Engineering", "Sales", "HR", "Finance", "Marketing"};
        System.out.println("Departments initialized: " + java.util.Arrays.toString(departments));

        System.out.println("Default bonus percentage set to: " + defaultBonusPercentage + "%");
        System.out.println("Static block completed!\n");
        System.out.println("\n*** STATIC BLOCK EXECUTION ENDS HERE ***\n");
    }


    // ========== CONSTRUCTOR ==========
    public Employee(String name, int id, String dept, double salary, int years) {
        System.out.println("Constructor called for: " + name);
        this.employeeName = name;
        this.employeeId = id;
        this.department = dept;
        this.salary = salary;
        this.yearsWorked = years;

        // Update static members
        totalEmployees++;
        totalSalaryPaid += salary;
    }


    // ========== STATIC METHODS - Can access static members directly ==========

    /**
     * Static method to display company information
     * Can be called without creating any Employee object
     */
    public static void displayCompanyInfo() {
        System.out.println("\n========== COMPANY INFORMATION (STATIC) ==========");
        System.out.println("Company Name: " + COMPANY_NAME);
        System.out.println("Founded: " + COMPANY_FOUNDED);
        System.out.println("Departments: " + java.util.Arrays.toString(departments));
        System.out.println("=".repeat(50));
    }

    /**
     * Static method to display employee statistics
     */
    public static void displayEmployeeStatistics() {
        System.out.println("\n========== EMPLOYEE STATISTICS (STATIC) ==========");
        System.out.println("Total Employees: " + totalEmployees);
        System.out.println("Total Salary Paid: $" + String.format("%.2f", totalSalaryPaid));
        System.out.println("Average Salary: $" + String.format("%.2f", totalSalaryPaid / (totalEmployees == 0 ? 1 : totalEmployees)));
        System.out.println("=".repeat(50));
    }

    /**
     * Static method to get bonus percentage
     */
    public static double getDefaultBonusPercentage() {
        return defaultBonusPercentage;
    }

    /**
     * Static method to set bonus percentage
     */
    public static void setDefaultBonusPercentage(double percentage) {
        if (percentage >= 0 && percentage <= 100) {
            System.out.println("Default bonus percentage updated from " + defaultBonusPercentage + "% to " + percentage + "%");
            defaultBonusPercentage = percentage;
        } else {
            System.out.println("Invalid percentage! Must be between 0 and 100");
        }
    }

    /**
     * Static method to get total employees count
     */
    public static int getTotalEmployees() {
        return totalEmployees;
    }

    /**
     * Static method to get total salary paid
     */
    public static double getTotalSalaryPaid() {
        return totalSalaryPaid;
    }

    /**
     * Static method to reset statistics
     */
    public static void resetStatistics() {
        System.out.println("\n*** RESETTING STATIC DATA ***");
        totalEmployees = 0;
        totalSalaryPaid = 0.0;
        defaultBonusPercentage = 5.0;
        System.out.println("Statistics reset to default values\n");
    }

    /**
     * Static method to check if department exists
     */
    public static boolean isDepartmentValid(String dept) {
        for (String d : departments) {
            if (d.equalsIgnoreCase(dept)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Static method to list all departments
     */
    public static void listDepartments() {
        System.out.println("\nDepartments in " + COMPANY_NAME + ":");
        for (int i = 0; i < departments.length; i++) {
            System.out.println((i + 1) + ". " + departments[i]);
        }
    }


    // ========== INSTANCE METHODS ==========

    /**
     * Instance method to display employee information
     */
    public void displayEmployeeInfo() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("ID: " + this.employeeId);
        System.out.println("Name: " + this.employeeName);
        System.out.println("Department: " + this.department);
        System.out.println("Salary: $" + String.format("%.2f", this.salary));
        System.out.println("Years Worked: " + this.yearsWorked);
        System.out.println("Company: " + COMPANY_NAME); // Accessing static constant
    }

    /**
     * Instance method to calculate bonus (uses static member)
     */
    public double calculateBonus() {
        // Using static variable in instance method
        return this.salary * (defaultBonusPercentage / 100);
    }

    /**
     * Instance method to display bonus
     */
    public void displayBonus() {
        double bonus = calculateBonus();
        System.out.println(this.employeeName + "'s Bonus (" + defaultBonusPercentage + "%): $" + String.format("%.2f", bonus));
    }

    /**
     * Instance method to get employee name
     */
    public String getEmployeeName() {
        return this.employeeName;
    }

    /**
     * Instance method to get salary
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * Instance method to give raise
     */
    public void giveRaise(double amount) {
        double oldSalary = this.salary;
        this.salary += amount;
        totalSalaryPaid += amount; // Update static variable
        System.out.println(this.employeeName + "'s salary raised from $" + String.format("%.2f", oldSalary)
                + " to $" + String.format("%.2f", this.salary));
    }
}
