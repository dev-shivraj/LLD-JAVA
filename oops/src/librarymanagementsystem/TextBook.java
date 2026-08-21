package librarymanagementsystem;

public class TextBook extends Book {
    private String subject;
    private int edition;

    public TextBook(String subject, int edition) {
        this.subject = subject;
        this.edition = edition;
    }

    public TextBook(String isbn, String title, String author, String subject, int edition) {
        super(isbn, title, author);
        this.subject = subject;
        this.edition = edition;
    }

    public TextBook(Book other, String subject, int edition) {
        super(other);
        this.subject = subject;
        this.edition = edition;
    }

    void displayBookDetails() {
        System.out.println("TextBook | Title: " + this.getTitle() +
                " | Author: " + getAuthor() +
                " | ISBN: " + getIsbn() +
                " | Subject: " + subject +
                " | Edition: " + edition);
    }
}
