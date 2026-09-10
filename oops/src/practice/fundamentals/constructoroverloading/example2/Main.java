package practice.fundamentals.constructoroverloading.example2;

public class Main {

    public static void main(String[] args) {

        Product product1 = new Product("Laptop");
        Product product2 = new Product("Laptop", 80000);

        System.out.println("Product 1:");
        product1.displayInfo();

        System.out.println();

        System.out.println("Product 2:");
        product2.displayInfo();
    }
}