package practice.fundamentals.thiskeyword.practice1;

public class Main {

    public static void main(String[] args) {

        Product product1 = new Product();
        product1.setDetails("Laptop", 80000, 2);

        Product product2 = new Product();
        product2.setDetails("Mouse", 1500, 3);

        System.out.println("Product 1:");
        product1.displayInfo();

        System.out.println();

        System.out.println("Product 2:");
        product2.displayInfo();
    }
}