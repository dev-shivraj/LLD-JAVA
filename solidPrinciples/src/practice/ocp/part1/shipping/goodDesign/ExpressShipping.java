package practice.ocp.part1.shipping.goodDesign;

public class ExpressShipping implements Shipping{
    @Override
    public void calculateShipping() {
        System.out.println("Calculating Express Shipping");
    }
}
