package practice.ocp.part1.shipping.goodDesign.newRequirement;

import practice.ocp.part1.shipping.goodDesign.Shipping;

public class SameDayShipping implements Shipping {
    @Override
    public void calculateShipping() {
        System.out.println("Calculating Same Day Shipping");
    }
}
