package src;

/**
 * DriverManagementSystem - Main demonstration class
 *
 * Concepts Covered:
 * 1. OBJECT CREATION - Creating objects using different constructors
 * 2. CONSTRUCTOR OVERLOADING - Multiple ways to initialize objects
 * 3. ENCAPSULATION - Using getters/setters instead of direct field access
 * 4. THIS KEYWORD - Reference to current object
 * 5. OBJECT REFERENCE - Understanding object references in memory
 * 6. GARBAGE COLLECTION - Object lifecycle and memory management
 * 7. STRING POOL - String interning behavior
 * 8. EQUALS vs == - Reference comparison vs content comparison
 * 9. TO_STRING - Proper object representation
 * 10. COPY CONSTRUCTOR - Creating object from another object
 * 11. OBJECT COMPARISON - equals() and hashCode()
 * 12. ASSOCIATION - Relationship between Driver and Rider
 * 13. COMPOSITION - Objects containing other objects
 */
public class DriverManagementSystem {

    public static void main(String[] args) {
        System.out.println("========== DRIVER MANAGEMENT SYSTEM ==========\n");

        // ========== SECTION 1: CONSTRUCTOR OVERLOADING ==========
        demonstrateConstructorOverloading();

        // ========== SECTION 2: ENCAPSULATION & GETTERS/SETTERS ==========
        demonstrateEncapsulation();

        // ========== SECTION 3: OBJECT REFERENCE & MEMORY ==========
        demonstrateObjectReference();

        // ========== SECTION 4: EQUALS vs == OPERATOR ==========
        demonstrateEqualsVsEqualsTo();

        // ========== SECTION 5: STRING POOL BEHAVIOR ==========
        demonstrateStringPool();

        // ========== SECTION 6: GARBAGE COLLECTION ==========
        demonstrateGarbageCollection();

        // ========== SECTION 7: COPY CONSTRUCTOR ==========
        demonstrateCopyConstructor();

        // ========== SECTION 8: OBJECT METHODS ==========
        demonstrateObjectBehavior();

        // ========== SECTION 9: ASSOCIATION & COMPOSITION ==========
        demonstrateAssociation();

        // ========== SECTION 10: VALIDATION & BUSINESS LOGIC ==========
        demonstrateValidation();
    }

    /**
     * Demonstrates Constructor Overloading
     * Shows different ways to create Driver objects
     */
    private static void demonstrateConstructorOverloading() {
        System.out.println("--- 1. CONSTRUCTOR OVERLOADING ---");

        // Constructor 1: Default constructor
        Driver driver1 = new Driver();
        System.out.println("Driver 1 created: " + driver1); // here toString() is called implicitly : meaning driver1 and driver1.toString() are same

        // Constructor 2: Parameterized constructor with all parameters
        Driver driver2 = new Driver(101, "John Doe", 4.8, true, "SUV", 5);
        System.out.println("Driver 2 created: " + driver2);

        // Constructor 3: Partial parameters
        Driver driver3 = new Driver(102, "Jane Smith");
        System.out.println("Driver 3 created: " + driver3);

        System.out.println();
    }

    /**
     * Demonstrates Encapsulation using Getters and Setters
     * Shows why we use private fields with public accessors
     */
    private static void demonstrateEncapsulation() {
        System.out.println("--- 2. ENCAPSULATION & GETTERS/SETTERS ---");

        Driver driver = new Driver(103, "Mike Johnson");

        // Using setters for controlled field modification
        driver.setRating(4.5);
        driver.setVehicleType("Sedan");
        driver.setYearsOfExperience(3);
        driver.setOnline(true);

        // Using getters to access fields safely
        System.out.println("Driver Name: " + driver.getName());
        System.out.println("Driver Rating: " + driver.getRating());
        System.out.println("Vehicle Type: " + driver.getVehicleType());
        System.out.println("Experience Level: " + driver.getExperienceLevel());

        // Setter with validation - invalid rating
        System.out.println("\nAttempting invalid rating (10.0):");
        driver.setRating(10.0); // This will print validation error

        System.out.println();
    }

    /**
     * Demonstrates Object References in Memory
     * Shows that variables hold references, not the actual object
     */
    private static void demonstrateObjectReference() {
        System.out.println("--- 3. OBJECT REFERENCE & MEMORY ---");

        Driver driver1 = new Driver(104, "Alice Cooper");
        driver1.setOnline(true);
        System.out.println("driver1: " + driver1);
        System.out.println("driver1 reference address: " + System.identityHashCode(driver1));

        // Creating a new reference to the same object
        Driver driver2 = driver1;
        System.out.println("\nAfter: Driver driver2 = driver1;");
        System.out.println("driver2: " + driver2);
        System.out.println("driver2 reference address: " + System.identityHashCode(driver2));
        System.out.println("Are they the same object? " + (driver1 == driver2)); // true

        // Modifying through driver2 affects driver1
        driver2.setName("Alice (Modified)");
        System.out.println("\nAfter modifying driver2.name:");
        System.out.println("driver1.getName(): " + driver1.getName()); // Shows modified name
        System.out.println("driver2.getName(): " + driver2.getName());

        System.out.println();
    }

    /**
     * Demonstrates equals() vs == operator
     * Shows the difference between reference equality and content equality
     */
    private static void demonstrateEqualsVsEqualsTo() {
        System.out.println("--- 4. EQUALS vs == OPERATOR ---");

        Driver driver1 = new Driver(105, "Bob Wilson");
        Driver driver2 = new Driver(105, "Bob Wilson");
        Driver driver3 = driver1;

        // == compares references
        System.out.println("driver1 == driver2 (different objects): " + (driver1 == driver2)); // false
        System.out.println("driver1 == driver3 (same object): " + (driver1 == driver3)); // true

        // equals() compares content (if overridden)
        System.out.println("driver1.equals(driver2) (same content): " + driver1.equals(driver2)); // true
        System.out.println("driver1.equals(driver3) (same object): " + driver1.equals(driver3)); // true

        Driver driver4 = new Driver(106, "Bob Wilson");
        System.out.println("driver1.equals(driver4) (different ID): " + driver1.equals(driver4)); // false

        System.out.println();
    }

    /**
     * Demonstrates String Pool Behavior
     * Shows how Java optimizes string storage
     */
    private static void demonstrateStringPool() {
        System.out.println("--- 5. STRING POOL BEHAVIOR ---");

        // Strings with same literal value often point to same object in memory (String Pool)
        String name1 = "John";
        String name2 = "John";
        System.out.println("name1 = \"John\"; name2 = \"John\";");
        System.out.println("name1 == name2: " + (name1 == name2)); // true (same reference)
        System.out.println("name1.equals(name2): " + (name1.equals(name2))); // true

        // Using new keyword creates separate objects in heap memory
        String name3 = new String("John");
        String name4 = new String("John");
        System.out.println("\nname3 = new String(\"John\"); name4 = new String(\"John\");");
        System.out.println("name3 == name4: " + (name3 == name4)); // false (different objects)
        System.out.println("name3.equals(name4): " + (name3.equals(name4))); // true (same content)

        System.out.println();
    }

    /**
     * Demonstrates Garbage Collection
     * Shows object lifecycle and memory deallocation
     */
    private static void demonstrateGarbageCollection() {
        System.out.println("--- 6. GARBAGE COLLECTION ---");

        Driver driver = new Driver(107, "Charlie Brown");
        System.out.println("Created driver: " + driver.getName());
        System.out.println("Driver reference: " + System.identityHashCode(driver));

        // Detach reference - object becomes eligible for garbage collection
        driver = null;
        System.out.println("\nAfter setting driver = null:");
        System.out.println("Driver reference: " + driver);
        System.out.println("Object is now eligible for garbage collection");

        // Note: We cannot force garbage collection, only suggest it
        System.gc(); // Suggests JVM to run garbage collector
        System.out.println("System.gc() called (suggestion, not guaranteed)");

        // Attempting to access null reference causes NullPointerException
        // Uncomment to see exception: System.out.println(driver.getName());

        System.out.println();
    }

    /**
     * Demonstrates Copy Constructor Pattern
     * Shows creating one object from another
     */
    private static void demonstrateCopyConstructor() {
        System.out.println("--- 7. COPY CONSTRUCTOR ---");

        Driver originalDriver = new Driver(108, "Diana Prince", 4.9, true, "Tesla", 7);
        System.out.println("Original Driver: " + originalDriver);

        // Copy constructor - creates independent copy
        Driver copiedDriver = new Driver(originalDriver);
        System.out.println("Copied Driver: " + copiedDriver);

        // Modifying copy doesn't affect original
        copiedDriver.setName("Diana Copy");
        System.out.println("\nAfter modifying copied driver:");
        System.out.println("Original: " + originalDriver.getName());
        System.out.println("Copy: " + copiedDriver.getName());

        System.out.println();
    }

    /**
     * Demonstrates Object Behavior through Methods
     * Shows how objects perform actions (methods)
     */
    private static void demonstrateObjectBehavior() {
        System.out.println("--- 8. OBJECT METHODS & BEHAVIOR ---");

        Driver driver = new Driver(109, "Edward Norton");
        driver.setOnline(false);
        driver.setRating(3.5);

        System.out.println("Current Status: " + driver);
        driver.changeStatus(); // Toggle online status

        driver.acceptRide("RIDE-001"); // Ride acceptance when online
        driver.acceptRide("RIDE-002");
        driver.completeRide("RIDE-001");
        driver.updateRating(4.0);

        System.out.println("Updated Status: " + driver);

        System.out.println();
    }

    /**
     * Demonstrates Association and Composition
     * Shows relationship between different objects
     */
    private static void demonstrateAssociation() {
        System.out.println("--- 9. ASSOCIATION & COMPOSITION ---");

        Driver driver = new Driver(110, "Fiona Green", 4.7, true, "Uber Black", 6);
        Rider rider = new Rider(201, "George Harris", "george@email.com");

        System.out.println("Driver: " + driver.getName());
        System.out.println("Rider: " + rider.getName());

        rider.addBalance(50.0);
        rider.bookRide("RIDE-ASSOC-001");
        driver.acceptRide("RIDE-ASSOC-001");
        driver.completeRide("RIDE-ASSOC-001");
        rider.completeRide(25.5); // Pay for ride

        System.out.println("After ride completion:");
        System.out.println("Driver: " + driver);
        System.out.println("Rider: " + rider);

        System.out.println();
    }

    /**
     * Demonstrates Validation and Business Logic
     * Shows proper data validation through encapsulation
     */
    private static void demonstrateValidation() {
        System.out.println("--- 10. VALIDATION & BUSINESS LOGIC ---");

        Driver driver = new Driver(111, "Grace Lopez");

        System.out.println("Attempting valid operations:");
        driver.setRating(4.5);
        driver.setYearsOfExperience(4);
        System.out.println("Valid rating set: " + driver.getRating());
        System.out.println("Valid years set: " + driver.getYearsOfExperience());

        System.out.println("\nAttempting invalid operations (validations prevent errors):");
        driver.setRating(-1.0); // Invalid: negative
        driver.setRating(6.0);  // Invalid: > 5.0
        driver.setName("");     // Invalid: empty
        driver.setDriverId(-5); // Invalid: negative

        System.out.println("\nFinal valid state: " + driver);

        System.out.println();
    }
}
