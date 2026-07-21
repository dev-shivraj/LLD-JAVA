package src;

/**
 * Driver class demonstrates core OOPS concepts:
 * 1. Encapsulation - private fields with public getters/setters
 * 2. Constructor Overloading - multiple ways to create objects
 * 3. Instance Variables - state of the object
 * 4. Methods - behavior of the object
 * 5. this keyword - reference to current object
 * 6. toString() override - proper string representation
 * 7. equals() override - object comparison
 * 8. Validation - business logic validation
 */
public class Driver {
    // Private instance variables (Encapsulation)
    private int driverId;
    private String name;
    private double rating;
    private boolean isOnline;
    private String vehicleType;
    private int yearsOfExperience;

    // Constructor 1: Default constructor
    public Driver() {
        this.driverId = 0;
        this.name = "Unknown";
        this.rating = 0.0;
        this.isOnline = false;
        this.vehicleType = "Sedan";
        this.yearsOfExperience = 0;
        System.out.println("Default constructor called - Driver initialized");
    }

    // Constructor 2: Overloaded constructor with all parameters
    public Driver(int driverId, String name, double rating, boolean isOnline, String vehicleType, int yearsOfExperience) {
        this.driverId = driverId;
        this.name = name;
        this.rating = rating;
        this.isOnline = isOnline;
        this.vehicleType = vehicleType;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Constructor 3: Overloaded constructor with partial parameters
    public Driver(int driverId, String name) {
        this.driverId = driverId;
        this.name = name;
        this.rating = 0.0;
        this.isOnline = false;
        this.vehicleType = "Sedan";
        this.yearsOfExperience = 0;
    }

    // Constructor 4: Overloaded constructor - copy constructor pattern
    public Driver(Driver other) {
        this.driverId = other.driverId;
        this.name = other.name;
        this.rating = other.rating;
        this.isOnline = other.isOnline;
        this.vehicleType = other.vehicleType;
        this.yearsOfExperience = other.yearsOfExperience;
    }

    // Getters and Setters (Encapsulation principle)
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        if (driverId > 0) {
            this.driverId = driverId;
        } else {
            System.out.println("Invalid Driver ID. Must be positive.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name. Cannot be empty.");
        }
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating >= 0.0 && rating <= 5.0) {
            this.rating = rating;
        } else {
            System.out.println("Invalid rating. Must be between 0.0 and 5.0");
        }
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience >= 0) {
            this.yearsOfExperience = yearsOfExperience;
        }
    }

    // Methods demonstrating behavior
    public void acceptRide(String rideId) {
        if (isOnline) {
            System.out.println("[" + name + "] Ride " + rideId + " has been accepted");
        } else {
            System.out.println("[" + name + "] Cannot accept ride - Driver is offline");
        }
    }

    public void completeRide(String rideId) {
        System.out.println("[" + name + "] Ride " + rideId + " has been completed");
    }

    // Toggle online status
    public void changeStatus() {
        isOnline = !isOnline;
        String status = isOnline ? "online" : "offline";
        System.out.println("Driver " + name + " is now " + status);
    }

    // Update rating (e.g., after ride completion)
    public void updateRating(double newRating) {
        if (newRating >= 0.0 && newRating <= 5.0) {
            this.rating = newRating;
            System.out.println("Driver " + name + " rating updated to " + newRating);
        }
    }

    // Calculate experience level based on years
    public String getExperienceLevel() {
        if (yearsOfExperience < 1) {
            return "Beginner";
        } else if (yearsOfExperience < 3) {
            return "Intermediate";
        } else if (yearsOfExperience < 5) {
            return "Experienced";
        } else {
            return "Expert";
        }
    }

    // Override toString() for meaningful string representation
    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", isOnline=" + isOnline +
                ", vehicleType='" + vehicleType + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", experienceLevel='" + getExperienceLevel() + '\'' +
                '}';
    }

    // Override equals() for object comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Same object reference
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Not same type
        }
        Driver driver = (Driver) obj;
        return driverId == driver.driverId && name.equals(driver.name);
    }

    // Override hashCode() - good practice when overriding equals()
    @Override
    public int hashCode() {
        return 31 * driverId + name.hashCode();
    }
}
