package practice.fundamentals.classandobjects.practice1;

public class Book {
    String title;
    String author;
    double price;

    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    void read() {
        System.out.println("Reading: " + title);
    }
}
