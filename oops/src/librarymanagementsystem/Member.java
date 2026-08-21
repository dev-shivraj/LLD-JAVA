package librarymanagementsystem;

public class Member extends User{
    private int borrowedBooksCount;
    private static final int MAX_BORROW_LIMIT = 5;

    // default constructor
    public Member() {
        super();
        this.borrowedBooksCount = 0;
    }

    // Parameterized constructor
    public Member(String name, String contactInfo) {
        super(name, contactInfo);
        this.borrowedBooksCount = 0;
    }

    // Parameterized constructor
    public Member(int borrowedBooksCount) {
        this.borrowedBooksCount = borrowedBooksCount;
    }

    @Override
    void displayDashboard() {
        System.out.println("--- Member Dashboard ---");
        System.out.println("Name : " + getName());
        System.out.println("Books Borrowed: " + borrowedBooksCount);
    }

    @Override
    boolean canBorrowBooks() {
        return borrowedBooksCount < MAX_BORROW_LIMIT;
    }

    public void incrementorrowCount() {
        borrowedBooksCount++;
    }

    public void decrementorrowCount() {
        borrowedBooksCount--;
    }

    public int getBorrowedBooksCount() {
        return borrowedBooksCount;
    }
}
