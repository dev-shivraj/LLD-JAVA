package src;
/*
 * CLIENT CLASS - Comprehensive demonstration of STATIC CONCEPTS
 *
 * Demonstrates:
 * 1. Static blocks execution
 * 2. Static variables and constants
 * 3. Static methods
 * 4. Instance variables and methods
 * 5. Interaction between static and instance members
 */

import javax.crypto.spec.PSource;

public class StaticCompleteDemo {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║  COMPREHENSIVE STATIC MEMBERS DEMONSTRATION            ║");
        System.out.println("║  (Static Block, Members, Methods & Instance Members)   ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");

        // ========== SECTION 1: STATIC BLOCK EXECUTION ==========
        System.out.println("\n\n📌 SECTION 1: STATIC BLOCK");
        System.out.println("\nNotice that the static block has not executed yet, but the Employee class is about to be loaded into memory when we will access it first time.\n");
        Employee.displayEmployeeStatistics();
        System.out.println();
        System.out.println("Notice that the static block executed BEFORE this line printed!");
        System.out.println("The static block above was executed when Employee class was FIRST LOADED");
        System.out.println("This happens BEFORE any objects are created!");


        // ========== SECTION 2: CALLING STATIC METHODS WITHOUT OBJECTS ==========
        System.out.println("\n\n📌 SECTION 2: ACCESSING STATIC MEMBERS & METHODS (NO OBJECTS CREATED YET)");
        System.out.println("Total employees before creating any: " + Employee.getTotalEmployees());

        Employee.displayCompanyInfo();
        Employee.listDepartments();
        Employee.displayEmployeeStatistics();


        // ========== SECTION 3: CREATING FIRST EMPLOYEE ==========
        System.out.println("\n\n📌 SECTION 3: CREATING EMPLOYEE OBJECTS");
        System.out.println("Creating first employee...");
        Employee emp1 = new Employee("Alice Johnson", 101, "Engineering", 75000, 3);
        emp1.displayEmployeeInfo();
        System.out.println("Total Employees: " + Employee.getTotalEmployees());


        // ========== SECTION 4: CREATING MORE EMPLOYEES ==========
        System.out.println("\n\nCreating second employee...");
        Employee emp2 = new Employee("Bob Smith", 102, "Sales", 60000, 2);
        emp2.displayEmployeeInfo();
        System.out.println("Total Employees: " + Employee.getTotalEmployees());

        System.out.println("\nCreating third employee...");
        Employee emp3 = new Employee("Charlie Davis", 103, "Marketing", 65000, 4);
        emp3.displayEmployeeInfo();
        System.out.println("Total Employees: " + Employee.getTotalEmployees());

        System.out.println("\nCreating fourth employee...");
        Employee emp4 = new Employee("Diana Wilson", 104, "Finance", 70000, 5);
        emp4.displayEmployeeInfo();
        System.out.println("Total Employees: " + Employee.getTotalEmployees());


        // ========== SECTION 5: STATIC METHODS ACCESS STATIC DATA ==========
        System.out.println("\n\n📌 SECTION 5: STATIC METHODS (Shared data across all instances)");
        Employee.displayEmployeeStatistics();


        // ========== SECTION 6: INSTANCE METHODS USING STATIC VARIABLES ==========
        System.out.println("\n\n📌 SECTION 6: INSTANCE METHODS USING STATIC MEMBERS");
        System.out.println("Current default bonus percentage: " + Employee.getDefaultBonusPercentage() + "%\n");

        System.out.println("Calculating bonus for each employee:");
        emp1.displayBonus();
        emp2.displayBonus();
        emp3.displayBonus();
        emp4.displayBonus();


        // ========== SECTION 7: MODIFYING STATIC MEMBER ==========
        System.out.println("\n\n📌 SECTION 7: MODIFYING STATIC MEMBER");
        System.out.println("Changing default bonus percentage to 10%...");
        Employee.setDefaultBonusPercentage(10.0);

        System.out.println("\nRecalculating bonuses with new percentage:");
        emp1.displayBonus();
        emp2.displayBonus();
        emp3.displayBonus();
        emp4.displayBonus();


        // ========== SECTION 8: INSTANCE METHODS MODIFYING STATIC DATA ==========
        System.out.println("\n\n📌 SECTION 8: INSTANCE METHODS UPDATING STATIC DATA");
        System.out.println("Giving raises to employees (updates static totalSalaryPaid):\n");

        emp1.giveRaise(5000);
        emp2.giveRaise(3000);

        System.out.println("\nAfter raises:");
        Employee.displayEmployeeStatistics();


        // ========== SECTION 9: STATIC MEMBERS SHARED ACROSS ALL INSTANCES ==========
        System.out.println("\n\n📌 SECTION 9: STATIC MEMBERS SHARED ACROSS ALL INSTANCES");
        System.out.println("Accessing static totalEmployees via different object references:");
        System.out.println("Via emp1: " + emp1.getTotalEmployees());
        System.out.println("Via emp2: " + emp2.getTotalEmployees());
        System.out.println("Via emp3: " + emp3.getTotalEmployees());
        System.out.println("Via emp4: " + emp4.getTotalEmployees());
        System.out.println("Via Employee class: " + Employee.getTotalEmployees());
        System.out.println("✓ All show SAME value (shared by all instances)\n");

        System.out.println("Accessing static defaultBonusPercentage via different references:");
        System.out.println("Via emp1: " + emp1.getDefaultBonusPercentage());
        System.out.println("Via emp2: " + emp2.getDefaultBonusPercentage());
        System.out.println("Via Employee class: " + Employee.getDefaultBonusPercentage());
        System.out.println("✓ All show SAME value (shared by all instances)");


        // ========== SECTION 10: VALIDATION USING STATIC METHOD ==========
        System.out.println("\n\n📌 SECTION 10: STATIC METHODS FOR VALIDATION");
        System.out.println("Is 'Engineering' a valid department? " + Employee.isDepartmentValid("Engineering"));
        System.out.println("Is 'IT' a valid department? " + Employee.isDepartmentValid("IT"));
        System.out.println("Is 'Sales' a valid department? " + Employee.isDepartmentValid("Sales"));


        // ========== SECTION 11: RESETTING STATIC DATA ==========
        System.out.println("\n\n📌 SECTION 11: RESETTING STATIC DATA");
        System.out.println("Before reset:");
        Employee.displayEmployeeStatistics();

        Employee.resetStatistics();

        System.out.println("After reset:");
        System.out.println("Total Employees: " + Employee.getTotalEmployees());
        System.out.println("Default Bonus %: " + Employee.getDefaultBonusPercentage());


        // ========== SECTION 12: CREATING NEW EMPLOYEE AFTER RESET ==========
        System.out.println("\n\n📌 SECTION 12: NEW EMPLOYEE AFTER RESET");
        Employee emp5 = new Employee("Eve Martinez", 105, "HR", 55000, 1);
        emp5.displayEmployeeInfo();

        System.out.println("\nStatistics after new employee:");
        Employee.displayEmployeeStatistics();


        // ========== SUMMARY ==========
        System.out.println("\n\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║                  KEY CONCEPTS SUMMARY                   ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        System.out.println("1️⃣  STATIC BLOCK:");
        System.out.println("   - Executed once when class is FIRST loaded");
        System.out.println("   - Before any object is created");
        System.out.println("   - Used for complex static initialization\n");

        System.out.println("2️⃣  STATIC VARIABLES:");
        System.out.println("   - Shared across ALL instances of the class");
        System.out.println("   - Exist even without creating objects");
        System.out.println("   - Updated by instance methods\n");

        System.out.println("3️⃣  STATIC CONSTANTS (static final):");
        System.out.println("   - Cannot be modified after initialization");
        System.out.println("   - Shared across all instances\n");

        System.out.println("4️⃣  STATIC METHODS:");
        System.out.println("   - Can be called without creating objects");
        System.out.println("   - Can access static members directly");
        System.out.println("   - Cannot access instance members directly\n");

        System.out.println("5️⃣  INSTANCE MEMBERS & METHODS:");
        System.out.println("   - Each object has its own copy");
        System.out.println("   - Can access static members");
        System.out.println("   - Can modify static members\n");

        System.out.println("6️⃣  INITIALIZATION ORDER:");
        System.out.println("   1. Static variables initialized");
        System.out.println("   2. Static block executed");
        System.out.println("   3. Then objects are created");
        System.out.println("   4. Constructors and instance methods run\n");
    }
}
