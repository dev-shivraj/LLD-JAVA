package practice.fundamentals.parameterizedconstructors.practice1;

public class Product {

    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double calculateTotal() {
        return this.price * this.quantity;
    }

    void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Price: " + this.price);
        System.out.println("Quantity: " + this.quantity);
        System.out.println("Total: " + this.calculateTotal());
    }
}