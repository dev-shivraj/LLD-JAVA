package practice.ocp.part1.shipping.goodDesign;

public class StandardShipping implements Shipping{
    @Override
    public void calculateShipping() {
        System.out.println("Calculating Standard Shipping");
    }
}
