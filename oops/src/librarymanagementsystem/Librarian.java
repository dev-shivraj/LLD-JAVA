package librarymanagementsystem;

public class Librarian extends User{
    private String employeeNumber;


    // Parameterized constructor
    public Librarian(String name, String contactInfo, String employeeNumber) {
        super(name, contactInfo);
        this.employeeNumber = employeeNumber;
    }
    void displayDashboard() {
//        Librarian Dashboard
        System.out.println("--- Librarian Dashboard ---");
        System.out.println("Employee Number : " + this.employeeNumber);
    }

    boolean canBorrowBooks() {
        return true;
    }

//    void addNewBook(Book book) {
//
//    }
//    void removeBook(Book book) {
//
//    }


}
