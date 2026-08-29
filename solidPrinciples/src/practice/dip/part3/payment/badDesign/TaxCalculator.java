package practice.dip.part3.payment.badDesign;

public class TaxCalculator {

    public double calculateTax(double amount) {

        System.out.println("Calculating tax");

        return amount * 0.18;
    }
}