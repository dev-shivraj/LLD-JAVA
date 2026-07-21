package src;

/**
 * Rider class demonstrates:
 * 1. Separate entity class with its own encapsulation
 * 2. Association - Rider can be associated with Driver
 * 3. Independent object lifecycle
 * 4. Composition pattern
 */
public class Rider {
    private int riderId;
    private String name;
    private String emailAddress;
    private double accountBalance;
    private int totalRidesCompleted;

    // Default constructor
    public Rider() {
        this.riderId = 0;
        this.name = "Unknown";
        this.emailAddress = "";
        this.accountBalance = 0.0;
        this.totalRidesCompleted = 0;
    }

    // Parameterized constructor
    public Rider(int riderId, String name, String emailAddress) {
        this.riderId = riderId;
        this.name = name;
        this.emailAddress = emailAddress;
        this.accountBalance = 100.0; // Default account balance
        this.totalRidesCompleted = 0;
    }

    // Getters and Setters
    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        if (riderId > 0) {
            this.riderId = riderId;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        if (accountBalance >= 0) {
            this.accountBalance = accountBalance;
        }
    }

    public int getTotalRidesCompleted() {
        return totalRidesCompleted;
    }

    // Methods
    public void bookRide(String rideId) {
        System.out.println("[" + name + "] Booking ride " + rideId);
    }

    public void cancelRide(String rideId) {
        System.out.println("[" + name + "] Cancelling ride " + rideId);
    }

    public void completeRide(double fare) {
        if (accountBalance >= fare) {
            accountBalance -= fare;
            totalRidesCompleted++;
            System.out.println("[" + name + "] Ride completed. Fare: $" + fare + ", Balance: $" + accountBalance);
        } else {
            System.out.println("[" + name + "] Insufficient balance for ride");
        }
    }

    public void addBalance(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("[" + name + "] Balance added: $" + amount + ", New balance: $" + accountBalance);
        }
    }

    @Override
    public String toString() {
        return "Rider{" +
                "riderId=" + riderId +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", accountBalance=" + accountBalance +
                ", totalRidesCompleted=" + totalRidesCompleted +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rider rider = (Rider) obj;
        return riderId == rider.riderId && name.equals(rider.name);
    }

    @Override
    public int hashCode() {
        return 31 * riderId + name.hashCode();
    }
}
