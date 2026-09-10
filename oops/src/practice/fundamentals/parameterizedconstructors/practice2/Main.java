package practice.fundamentals.parameterizedconstructors.practice2;

public class Main {

    public static void main(String[] args) {

        Book book1 = new Book("Clean Code", "Robert Martin", 500);
        Book book2 = new Book("Effective Java", "Joshua Bloch", 700);
        Book book3 = new Book("Design Patterns", "Gang of Four", 900);

        System.out.println("Book 1:");
        book1.displayInfo();

        System.out.println();

        System.out.println("Book 2:");
        book2.displayInfo();

        System.out.println();

        System.out.println("Book 3:");
        book3.displayInfo();
    }
}