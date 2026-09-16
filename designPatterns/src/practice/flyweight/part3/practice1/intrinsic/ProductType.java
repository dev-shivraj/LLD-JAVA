package practice.flyweight.part3.practice1.intrinsic;

public class ProductType {

    private final String brand;
    private final String category;
    private final String image;

    public ProductType(
            String brand,
            String category,
            String image
    ) {
        this.brand = brand;
        this.category = category;
        this.image = image;
    }

    public void display(
            String productId,
            double price,
            int stock
    ) {
        System.out.println(
                "Product ID: " + productId +
                " | Brand: " + brand +
                " | Category: " + category +
                " | Image: " + image +
                " | Price: " + price +
                " | Stock: " + stock
        );
    }
}