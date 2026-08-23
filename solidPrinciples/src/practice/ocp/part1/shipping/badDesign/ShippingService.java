package practice.ocp.part1.shipping.badDesign;

public class ShippingService {

    public void calculateShipping(String type) {
        if (type.equals("STANDARD")) {
            System.out.println("Calculating Standard Shipping");
        } else if (type.equals("EXPRESS")) {
            System.out.println("Calculating Express Shipping");
        } else if (type.equals("INTERNATIONAL")) {
            System.out.println("Calculating International Shipping");
        }
    }
}