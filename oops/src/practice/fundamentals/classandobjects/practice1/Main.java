package practice.fundamentals.classandobjects.practice1;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.title = "Clean Code";
        book1.author = "Robert C. Martin";
        book1.price = 500;

        Book book2 = new Book();
        book2.title = "Effective Java";
        book2.author = "Joshua Bloch";
        book2.price = 700;

        Book book3 = new Book();
        book3.title = "Design Patterns";
        book3.author = "Erich Gamma";
        book3.price = 900;

        book1.displayInfo();
        book1.read();
        System.out.println();

        book2.displayInfo();
        book2.read();
        System.out.println();

        book3.displayInfo();
        book3.read();
    }
}
