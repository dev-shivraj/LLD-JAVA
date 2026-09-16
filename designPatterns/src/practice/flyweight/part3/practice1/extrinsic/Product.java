package practice.flyweight.part3.practice1.extrinsic;

import practice.flyweight.part3.practice1.intrinsic.ProductType;

public class Product {

    private final String productId;
    private final double price;
    private final int stock;
    private final ProductType productType;

    public Product(
            String productId,
            double price,
            int stock,
            ProductType productType
    ) {
        this.productId = productId;
        this.price = price;
        this.stock = stock;
        this.productType = productType;
    }

    public void display() {
        productType.display(productId, price, stock);
    }

    public ProductType getProductType() {
        return productType;
    }
}