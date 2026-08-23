package practice.ocp.part1.shipping.goodDesign;

public class InternationalShipping implements Shipping{
    @Override
    public void calculateShipping() {
        System.out.println("Calculating International Shipping");
    }
}
