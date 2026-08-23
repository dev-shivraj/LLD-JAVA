package practice.ocp.part1.shipping.goodDesign;

import practice.ocp.part1.shipping.goodDesign.newRequirement.SameDayShipping;

public class ShippingClient {
    public static void main(String[] args) {
        Shipping standardShipping = new StandardShipping();
        Shipping expressShipping = new ExpressShipping();
        Shipping internationalShipping = new InternationalShipping();

        // new requirement
        Shipping sameDayShipping = new SameDayShipping();



        standardShipping.calculateShipping();
        expressShipping.calculateShipping();
        internationalShipping.calculateShipping();

        // new requirement
        sameDayShipping.calculateShipping();
    }
}
