package practice.strategy.part3.practice3.strategy.tax;

public class GstTax implements TaxStrategy {

    @Override
    public double calculateTax(double price) {
        return price * 0.18;
    }
}