package practice.fundamentals.constructorchaining.practice1;

public class Product {

    String name;
    double price;
    int quantity;

    Product() {
        this("Unknown");
    }

    Product(String name) {
        this(name, 0);
    }

    Product(String name, double price) {
        this(name, price, 0);
    }

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}