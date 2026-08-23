package practice.ocp.part2.shipping.badDesign;

public class ShippingCalculator {

    public double calculate(String type, double weight) {
        if (type.equals("STANDARD")) {
            return weight * 5;
        } else if (type.equals("EXPRESS")) {
            return weight * 10;
        } else if (type.equals("INTERNATIONAL")) {
            return weight * 20;
        }
        return 0;
    }
}