package practice.strategy.part3.practice1.strategy;

public class SameDayShipping implements ShippingStrategy {

    @Override
    public double calculateShipping(double weight) {
        return weight * 20;
    }
}