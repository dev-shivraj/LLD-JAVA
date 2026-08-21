package librarymanagementsystem;

public abstract class User {
    private static int idCounter = 0;
    private static int totalUser = 0;
    private final String userId;
    private String name;
    private String contactInfo;

    abstract void displayDashboard();
    abstract boolean canBorrowBooks();

    // Default constructor
    public User() {
        this.userId = generateUniqueId();
        totalUser++;
    }

    // Parameterized constructor
    public User(String name, String contactInfo) {
        this.userId = generateUniqueId();
        this.name = name;
        this.contactInfo = contactInfo;
        totalUser++;
    }

    // Copy constructor
    public User(User other) {
        this.userId = generateUniqueId();
        this.name = other.name;
        this.contactInfo = other.contactInfo;
        totalUser++;
    }

    public static int getTotalUser() {
        return totalUser;
    }
    public static String generateUniqueId() {
        return "U-" + (++idCounter);
    }

    public String getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getContactInfo() {
        return this.contactInfo;
    }

}
