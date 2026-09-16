package practice.flyweight.part3.practice1.factory;

import practice.flyweight.part3.practice1.intrinsic.ProductType;

import java.util.HashMap;
import java.util.Map;

public class ProductTypeFactory {

    private final Map<String, ProductType> productTypes = new HashMap<>();

    public ProductType getProductType(String brand, String category, String image) {
        String key = brand + "_" + category + "_" + image;

        return productTypes.computeIfAbsent(key, ignored -> new ProductType(brand, category, image));
    }
}