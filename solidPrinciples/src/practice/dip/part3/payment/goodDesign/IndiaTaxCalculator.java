package practice.dip.part3.payment.goodDesign;

public class IndiaTaxCalculator
        implements TaxCalculator {

    @Override
    public double calculateTax(double amount) {

        System.out.println("Calculating Indian tax");

        return amount * 0.18;
    }
}