package practice.fundamentals.constructoroverloading.example2;

public class Product {

    String name;
    double price;

    Product(String name) {
        this.name = name;
        price = 0;
    }

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}