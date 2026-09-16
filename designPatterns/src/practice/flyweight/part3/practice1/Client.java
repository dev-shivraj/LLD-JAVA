package practice.flyweight.part3.practice1;

import practice.flyweight.part3.practice1.extrinsic.Product;
import practice.flyweight.part3.practice1.factory.ProductTypeFactory;
import practice.flyweight.part3.practice1.intrinsic.ProductType;

public class Client {

    public static void main(String[] args) {

        ProductTypeFactory factory = new ProductTypeFactory();

        ProductType nikeShoes = factory.getProductType("Nike", "Shoes", "nike-shoes.png");
        ProductType sameNikeShoes = factory.getProductType("Nike", "Shoes", "nike-shoes.png");
        ProductType applePhone = factory.getProductType("Apple", "Mobile", "iphone.png");

        Product product1 = new Product("P1001", 7999, 20, nikeShoes);
        Product product2 = new Product("P1002", 8999, 10, sameNikeShoes);
        Product product3 = new Product("P1003", 79999, 5, applePhone);

        product1.display();
        product2.display();
        product3.display();

        System.out.println();
        System.out.println("nikeShoes == sameNikeShoes: " + (nikeShoes == sameNikeShoes));
        System.out.println("nikeShoes == applePhone: " + (nikeShoes == applePhone));
    }
}