package practice.fundamentals.constructorchaining.practice1;

public class Main {

    public static void main(String[] args) {

        Product product1 = new Product();
        Product product2 = new Product("Laptop");
        Product product3 = new Product("Mouse", 1500);
        Product product4 = new Product("Keyboard", 3000, 2);

        System.out.println("Product 1:");
        product1.displayInfo();

        System.out.println();

        System.out.println("Product 2:");
        product2.displayInfo();

        System.out.println();

        System.out.println("Product 3:");
        product3.displayInfo();

        System.out.println();

        System.out.println("Product 4:");
        product4.displayInfo();
    }
}